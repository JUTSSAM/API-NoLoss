package com.noloss.api.Service.impl;

import com.noloss.api.Mapper.ArticleMapper;
import com.noloss.api.Model.Article;
import com.noloss.api.Service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

/**
 * Created by Jutssam on 2017/4/5.
 */
@Service
public class HelloServiceImpl implements HelloService {

    @Autowired
    ArticleMapper articleMapper;

    @Override
    public Article DemoHello(int id) {
        Article article = new Article();
        article = articleMapper.getArticleById(id, 1);
        return article;
    }
}
