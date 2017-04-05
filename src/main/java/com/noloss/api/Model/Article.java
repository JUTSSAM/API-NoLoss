package com.noloss.api.Model;

import lombok.Data;

import java.sql.Date;

/**
 * 文章
 */
@Data
public class Article {

    private long id;
    private String title;
    private String abstra;
    private String content;
    private String token;
    private Date   createtime;
    private Date   modifytime;

}
