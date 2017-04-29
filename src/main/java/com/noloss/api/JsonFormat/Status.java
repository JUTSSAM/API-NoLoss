package com.noloss.api.JsonFormat;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Status {
    private long code;
    private Content content;

    public Status(long code, Content content) {
        this.code = code;
        this.content = content;
    }
}
