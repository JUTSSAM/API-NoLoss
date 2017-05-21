package com.noloss.api.Service.impl;

import com.noloss.api.JsonFormat.ArticleInfo;
import com.noloss.api.JsonFormat.Msg;
import com.noloss.api.Mapper.ArticleMapper;
import com.noloss.api.Model.Article;
import com.noloss.api.Model.User;
import com.noloss.api.Service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by ${Jutssam} on 2017/4/29.
 */
@Service
public class ArticleServiceImpl implements ArticleService{

    @Autowired
    private ArticleMapper articleMapper;

    @Override
    public ArticleInfo getArticle(long id,String utoken) {
        Article article = articleMapper.getArticle(id,utoken);
        return new ArticleInfo(article.getId(),article.getTitle(),article.getContent(),article.getModifytime());
    }

    @Override
    public Msg saveArticle(Article article) {
        User user = articleMapper.SwitchTokenToId(article.getUtoken());
        article.setUserId(user.getId());
        Integer num = articleMapper.findArticleById(article.getId(),user.getId());
        if (num > 0){
            articleMapper.updateArticle(article.getUserId(),article.getId(),article.getTitle(),article.getContent(),article.getModifytime());
            return new Msg(200,article.getId());
        }
        else
        {
            articleMapper.addArticle(article);
            return new Msg(200,article.getId());
        }
    }

    @Override
    public long delArticle(long id,String utoken) {
        System.out.println("删除文章id："+id);
        User user = articleMapper.SwitchTokenToId(utoken);
        long num = articleMapper.updateArticleStatus(user.getId(),id,-1);
        return num;
    }
}
