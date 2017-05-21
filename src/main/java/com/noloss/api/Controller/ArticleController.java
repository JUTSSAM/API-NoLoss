package com.noloss.api.Controller;

import com.noloss.api.JsonFormat.ArticleInfo;
import com.noloss.api.JsonFormat.ArticleList;
import com.noloss.api.JsonFormat.Msg;
import com.noloss.api.Mapper.ArticleMapper;
import com.noloss.api.Model.Article;
import com.noloss.api.Service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jutssam on 2017/3/24.
 */

@RestController
@RequestMapping("article")
public class ArticleController {

    @Autowired
    private ArticleMapper articleMapper;
    private ArticleService articleService;

    // 根据文章id获取文章内容
    @GetMapping("get")
    public ArticleInfo getArticle(@RequestParam("id") long id, @RequestParam("utoken") String utoken){
        return articleService.getArticle(id,utoken);
    }

    // 新建、修改文章
    @PostMapping("save")
    public Msg saveArticle(@ModelAttribute("article") Article article) {
        return articleService.saveArticle(article);
    }

    // 删除文章
    @PostMapping("del")
    public Msg delArticleByToken(@RequestParam("id") long id,@RequestParam("utoken") String utoken){
        long num = articleService.delArticle(id,utoken);
        if (num > 0){
            return new Msg(200,1);
        }
        return new Msg(0,0);
    }

    // 获取文章列表
    @RequestMapping("/list")
    public List<ArticleList> getArticleLists(@RequestParam("utoken") String utoken){
        System.out.println(utoken);
        List<Article> articles = articleMapper.getArticleLists(utoken,1);
        List<ArticleList> articleList = new ArrayList<ArticleList>();
        for (Article article : articles) {
            articleList.add(new ArticleList(article.getId(),article.getTitle(),article.getModifytime()));
            System.out.println("id:"+article.getId()+"|title:"+article.getTitle()+"|modifytime:"+article.getModifytime());
        }
        return articleList;
    }
}
