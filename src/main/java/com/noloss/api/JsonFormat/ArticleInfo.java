package com.noloss.api.JsonFormat;

import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

/**
 * Created by ${Jutssam} on 2017/4/29.
 */

@Getter
@Setter
public class ArticleInfo {
    private long id;
    private String title;
    private String content;
    private Timestamp modifytime;

    public ArticleInfo(long id, String title, String content, Timestamp modifytime) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.modifytime = modifytime;
    }
}
