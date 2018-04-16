package com.cc.encoder;

import com.cc.util.ObjectConvertUtils;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;


/**
 * Created by Administrator on 2018/4/11.
 */
public class Encoder extends MessageToByteEncoder {

    @Override
    protected void encode(ChannelHandlerContext channelHandlerContext, Object o, ByteBuf byteBuf) throws Exception {
        byte[] body = ObjectConvertUtils.object2Bytes(o);
        int dataLength = body.length;
        byteBuf.writeInt(dataLength);
        byteBuf.writeBytes(body);
    }

}
