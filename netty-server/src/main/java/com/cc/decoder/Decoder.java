package com.cc.decoder;

import com.cc.message.ChatMessage;
import com.cc.message.Message;
import com.cc.util.ObjectConvertUtils;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * Created by Administrator on 2018/4/11.
 */
public class Decoder extends ByteToMessageDecoder {
    private final static Logger logger = LoggerFactory.getLogger(Decoder.class);
    @Override
    protected void decode(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, List<Object> list) throws Exception {
//        byteBuf.
        logger.info("message readableBytes : " + byteBuf.readableBytes());

        while (true){

            if (byteBuf.readableBytes() < 37){
                break;
            }

            byte[] messageId = new byte[32];
            byteBuf.readBytes(messageId);
            logger.info("message id : " + new String(messageId));
            byte[] version = new byte[5];
            byteBuf.readBytes(version);
            logger.info("message version : " + new String(version));



//        byte[] body = new byte[bodyLength];
//        byteBuf.readBytes(body);

            int remainLengh = byteBuf.readableBytes();
            logger.info("message remain readableBytes : " + remainLengh);



            ChatMessage chatMessage = new ChatMessage();
            chatMessage = chatMessage.decode(byteBuf);

            logger.info("content : " + chatMessage.getContent());
            logger.info("receive id  : " + chatMessage.getReceiveId());

            chatMessage.setVersion(version.toString());
            chatMessage.setId(messageId.toString());

            list.add(chatMessage);
        }


    }
}
