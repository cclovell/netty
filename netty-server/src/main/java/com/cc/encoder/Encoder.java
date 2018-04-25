package com.cc.encoder;

import com.cc.decoder.Decoder;
import com.cc.message.ChatMessage;
import com.cc.message.Message;
import com.cc.util.ObjectConvertUtils;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * Created by Administrator on 2018/4/11.
 */
public class Encoder extends MessageToByteEncoder<Message> {
    private final static Logger logger = LoggerFactory.getLogger(Encoder.class);

    @Override
    protected void encode(ChannelHandlerContext channelHandlerContext, Message message, ByteBuf byteBuf) throws Exception {

        byteBuf.writeBytes(message.getId().getBytes());
        byteBuf.writeBytes(message.getVersion().getBytes());

        byte[] body = message.encode();
        byteBuf.writeInt(body.length);


        byteBuf.writeBytes(body);
    }
}
