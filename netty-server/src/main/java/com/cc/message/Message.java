package com.cc.message;

import io.netty.buffer.ByteBuf;

/**
 * Created by Administrator on 2018/4/16.
 */
public abstract class Message {
    private String id;
    private String version;
    private Integer length;

    public String getId() {
        return id;
    }

    public Integer getLength() {
        return length;
    }

    public void setLength(Integer length) {
        this.length = length;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public abstract byte[] encode();
    public abstract Message decode(ByteBuf byteBuf);
}
