package com.cc.message;


import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;

import java.io.Serializable;
import java.nio.ByteBuffer;

/**
 * Created by Administrator on 2018/4/12.
 */
public class ChatMessage extends Message implements Serializable {

    private String receiveId;
    private String content;

    public String getReceiveId() {
        return receiveId;
    }

    public void setReceiveId(String receiveId) {
        this.receiveId = receiveId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public byte[] encode() {
        byte[] body =  new byte[receiveId.getBytes().length + content.getBytes().length];
        ByteBuf byteBuf = Unpooled.buffer();
        byteBuf.writeBytes(receiveId.getBytes());
        byteBuf.writeBytes(content.getBytes());
        byteBuf.readBytes(body);
        return body;
    }

    @Override
    public ChatMessage decode(ByteBuf byteBuf) {
        byte[] receiveIdByte = new byte[1];
        byteBuf.readBytes(receiveIdByte);
        this.receiveId = new String(receiveIdByte);
        byte[] contentByte = new byte[byteBuf.readableBytes()];
        byteBuf.readBytes(contentByte);
        this.content = new String(contentByte);
        return this;
    }

}
