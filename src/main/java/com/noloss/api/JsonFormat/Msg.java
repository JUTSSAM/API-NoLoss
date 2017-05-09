package com.noloss.api.JsonFormat;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Msg {
    private long code;
    private long msg;

    public Msg(long code, long msg) {
        this.code = code;
        this.msg = msg;
    }
}
