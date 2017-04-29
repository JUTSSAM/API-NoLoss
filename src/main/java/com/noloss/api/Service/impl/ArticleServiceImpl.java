package com.noloss.api.Service.impl;

import com.noloss.api.JsonFormat.ArticleList;
import com.noloss.api.Mapper.ArticleMapper;
import com.noloss.api.Model.Article;
import com.noloss.api.Service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;

/**
 * Created by ${Jutssam} on 2017/4/29.
 */
@Service
public class ArticleServiceImpl implements ArticleService{

    @Autowired
    private ArticleMapper articleMapper;

    @Override
    public Article getArticleById(int id) {
        return null;
    }

    @Override
    public ArticleList getArticleList(String utoken) {
        return null;
    }

    @Override
    public Integer checkArticleExist(String utoken, long id) {
        return articleMapper.findArticleById(id,utoken);
    }

    @Override
    public Article createNewArticle(String utoken, long id, String title, String content, Timestamp modifytime) {
        return null;
    }

    @Override
    public Article updateArticle(long id, String title, String content, Timestamp modifytime) {
        return null;
    }
}
