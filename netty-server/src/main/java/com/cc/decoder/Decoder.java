package com.cc.decoder;

import com.cc.util.ObjectConvertUtils;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;

import java.util.List;

/**
 * Created by Administrator on 2018/4/11.
 */
public class Decoder extends ByteToMessageDecoder {
    @Override
    protected void decode(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, List<Object> list) throws Exception {
        byteBuf.markReaderIndex();
        int dataLengh = byteBuf.readInt();

        byte[] body = new byte[dataLengh];
        byteBuf.readBytes(body);
        Object object = ObjectConvertUtils.bytes2Object(body);

        list.add(object);
    }
}
