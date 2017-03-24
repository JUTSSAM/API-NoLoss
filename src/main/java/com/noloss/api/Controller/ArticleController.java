package com.noloss.api.Controller;

import com.noloss.api.Mapper.ArticleMapper;
import com.noloss.api.Model.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Jutssam on 2017/3/24.
 */

@RestController
@RequestMapping("article")
public class ArticleController {

    @Autowired
    private ArticleMapper articleMapper;


    /**
     * 根据文章id获取文章内容
     * @param id 文章id
     * @param utoken 用户身份令牌
     * @return 文章内容
     */
    @GetMapping("get")
    public Article getArticleById(@RequestParam("id") long id, @RequestParam("utoken") String utoken){
        return articleMapper.getArticleById(id,utoken);
    }

//    @GetMapping("add")
//    public Article addToArticle(){
//
//    }


}
