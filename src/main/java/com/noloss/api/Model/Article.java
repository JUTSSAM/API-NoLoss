package com.noloss.api.Model;

import com.noloss.api.JsonFormat.ArticleList;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.sql.Date;
import java.sql.Timestamp;

/**
 * 文章
 */
@Data
public class Article{

    private long id;
    private String title;
    private String abstra;
    private String content;
    private String token;
    private Timestamp createtime;
    private Timestamp modifytime;

    public long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public Timestamp getModifytime() {
        return modifytime;
    }
}
