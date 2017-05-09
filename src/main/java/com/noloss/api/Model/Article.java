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
    private String content;
    private String utoken;
    private Timestamp createtime;
    private Timestamp modifytime;

    public void setId(long id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setCreatetime(Timestamp createtime) {
        this.createtime = createtime;
    }

    public void setModifytime(Timestamp modifytime) {
        this.modifytime = modifytime;
    }

    public void setUtoken(String utoken) {
        this.utoken = utoken;
    }

    public String getUtoken() {
        return utoken;
    }

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
