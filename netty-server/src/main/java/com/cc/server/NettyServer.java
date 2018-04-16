package com.cc.server;

import com.cc.decoder.Decoder;
import com.cc.encoder.Encoder;
import com.cc.handler.NettyServerHandler;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * Created by Administrator on 2018/3/27.
 */
@Component
public class NettyServer{
    private static final Logger logger = LoggerFactory.getLogger(NettyServer.class);
    public void bind(String ip, int port) throws Exception {
        System.out.println("<<<<<<<<<<<<这个是测试CommandLineRunn接口>>>>>>>>>>>>>>");
        EventLoopGroup bossGroup = new NioEventLoopGroup(1);
        EventLoopGroup workerGroup = new NioEventLoopGroup();
        ServerBootstrap b = new ServerBootstrap();
        b.group(bossGroup, workerGroup).channel(NioServerSocketChannel.class)
                .option(ChannelOption.SO_BACKLOG, 100)
                .handler(new LoggingHandler(LogLevel.INFO))
                .childHandler(new ChannelInitializer<SocketChannel>() {
                    @Override
                    public void initChannel(SocketChannel ch)
                            throws IOException {
                        ch.pipeline().addLast(
                                new Decoder());
                        ch.pipeline().addLast(new Encoder());
                        ch.pipeline().addLast(new NettyServerHandler());
                    }
                });

        // 绑定端口，同步等待成功
        ChannelFuture future = b.bind(ip,port).sync();
        logger.info("Netty server start ok host:{}, port:{}"
                , "127.0.0.1" , 8870);

//        future.channel().closeFuture().sync();
    }
}
