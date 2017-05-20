package com.noloss.api.Service;

import com.noloss.api.JsonFormat.ArticleList;
import com.noloss.api.Model.Article;

import java.sql.Timestamp;

/**
 * Created by Jutssam on 2017/4/19.
 */
public interface ArticleService {
    Article getArticleById(int id);
    ArticleList getArticleList(String utoken);
    Integer checkArticleExist(String utoken, long id);//检查文章是否存在
    Article createNewArticle(String utoken, long id, String title, String content, Timestamp modifytime);
    Article updateArticle(long id, String title, String content, Timestamp modifytime);
}
