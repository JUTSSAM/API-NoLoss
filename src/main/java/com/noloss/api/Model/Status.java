package com.noloss.api.Model;

/**
 * 返回json数据格式
 *
 */

public class Status {
    private long code;
    private String msg;

    public Status(long code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public long getCode() {
        return code;
    }

    public void setCode(long code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
