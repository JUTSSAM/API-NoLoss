package com.noloss.api.JsonFormat;

import com.noloss.api.Model.Article;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;
import java.util.Date;

/**
 * Created by ${Jutssam} on 2017/4/29.
 */
@Getter
@Setter
public class ArticleList{
    private long id;
    private String title;
    private long modifytime;

    public ArticleList(long id, String title, Date modifytime) {

        this.id = id;
        this.title = title;
        this.modifytime = modifytime.getTime();
    }
}
