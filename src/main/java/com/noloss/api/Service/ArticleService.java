package com.noloss.api.Service;

import com.noloss.api.JsonFormat.ArticleInfo;
import com.noloss.api.JsonFormat.Msg;
import com.noloss.api.Model.Article;

import java.sql.Timestamp;
import java.util.List;

/**
 * Created by Jutssam on 2017/4/19.
 */
public interface ArticleService {
    ArticleInfo getArticle(long id,String utoken);
    Msg saveArticle(Article article);
    long delArticle(long id,String utoken);
}
