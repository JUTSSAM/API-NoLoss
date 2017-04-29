package com.noloss.api.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Generated;
import lombok.Getter;
import lombok.Setter;

/**
 * Created by ${Jutssam} on 2017/4/29.
 */
@Getter
@Setter
public class Content {
    private String info;
    private String msg;

    public Content(String info, String msg) {
        this.info = info;
        this.msg = msg;
    }
}
