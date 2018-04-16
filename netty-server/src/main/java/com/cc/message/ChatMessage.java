package com.cc.message;


import java.io.Serializable;

/**
 * Created by Administrator on 2018/4/12.
 */
public class ChatMessage implements Serializable {

    private Integer id;
    private String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
