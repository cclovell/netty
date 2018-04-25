package com.cc.handler;

import com.cc.message.ChatMessage;
import com.cc.server.NettyServer;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by Administrator on 2018/4/12.
 */
public class NettyServerHandler extends SimpleChannelInboundHandler {
    private static final Logger logger = LoggerFactory.getLogger(NettyServer.class);
    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, Object o) throws Exception {
        ChatMessage chatMessage = new ChatMessage();
        if (o instanceof ChatMessage){
            chatMessage = (ChatMessage)o;

        }

        logger.info("server receive chatMessage content : " + chatMessage.getContent());
        logger.info("server receive chatMessage receiveId: " + chatMessage.getReceiveId());

//        chatMessage.setContent("server response");
//        channelHandlerContext.writeAndFlush(chatMessage);
    }
}
