package com.cc.client;

import com.cc.decoder.Decoder;
import com.cc.encoder.Encoder;
import com.cc.handler.ClientHandler;
import com.cc.message.ChatMessage;
import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * Created by Administrator on 2018/4/12.
 */
@Component
public class NettyClient  {
    private Logger logger = LoggerFactory.getLogger(getClass());

    private EventLoopGroup group = new NioEventLoopGroup();
    public void connect(String ip, int port) throws Exception {
        Bootstrap bootstrap = new Bootstrap();

        try {
            bootstrap.group(group).channel(NioSocketChannel.class).option(ChannelOption.TCP_NODELAY,true).handler(
                    new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel socketChannel) throws Exception {
                            socketChannel.pipeline().addLast(new Encoder());
                            socketChannel.pipeline().addLast(new Decoder());
                            socketChannel.pipeline().addLast(new ClientHandler());
                        }
                    }
            );

            ChannelFuture future = bootstrap.connect(ip, port).sync();

            if (future.awaitUninterruptibly(5000)) {
                logger.info("client connect host:{}, port:{}", ip, port);
                if (future.channel().isActive()) {
                    logger.info("开始发送消息");
                    for(int i=0; i<1; i++){

                        ChatMessage chatMessage = new ChatMessage();
                        chatMessage.setId(1);
                        chatMessage.setMessage("hallow server");


                        future.channel().writeAndFlush(chatMessage);
                    }
                    logger.info("发送消息完毕");
                }
            }

        }catch (Exception e){


        } finally {
        }
    }
}
