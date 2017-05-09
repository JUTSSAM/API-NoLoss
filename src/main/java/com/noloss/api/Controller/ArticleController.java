package com.noloss.api.Controller;

import com.noloss.api.JsonFormat.*;
import com.noloss.api.Mapper.ArticleMapper;
import com.noloss.api.Model.Article;
import com.noloss.api.Service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
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

    /**
     * 根据文章id获取文章内容
     * @param id 文章id
     * @param utoken 用户身份令牌
     * @return 文章内容
     */
    @GetMapping("get")
    public ArticleInfo getArticle(@RequestParam("id") long id, @RequestParam("utoken") String utoken){
        Article article = articleMapper.getArticleById(id,utoken);
        return new ArticleInfo(article.getId(),article.getTitle(),article.getContent(),article.getModifytime());
    }

    /**
     * 根据文章token获取文章内容
     * @TODO 根據文章token獲取文章功能已刪除
     * @param token 文章token
     * @param utoken 用户token
     * @return 文章内容
    @GetMapping("Get")
    public Article getArticleByToken(@RequestParam("token") String token,@RequestParam("utoken") String utoken){
        return articleMapper.getArticleByToken(token,utoken);
    }
     */

    /**
     * 修改，新增文章内容：
     * 根據手機端傳來的值中是否含有id，區分 更新/新增 文章
     * 新增文章則調用增加接口
     * 更新則調用更新接口
     * @param article 文章form
     * @return Status

    @PutMapping("save2")
    public Status saveArticle(@RequestParam("utoken") String utoken, @RequestParam(value = "id",defaultValue = "0") long id, @RequestParam("title") String title, @RequestParam("content") String content, @RequestParam("modifytime") Timestamp modifytime) {
        Integer num = articleMapper.findArticleById(id, utoken);
        if (num > 0){
            long re = articleMapper.updateArticle(utoken,id,title,content,modifytime);
            return new Status(200,new Content("修改成功",""+re));
        }
        else
        {
            long re = articleMapper.addArticle(title,content,utoken,modifytime,modifytime);
            return new Status(200,new Content("新增成功",""+re));
        }
    }
     */

    @PostMapping("save")
    public Msg saveArticle(@ModelAttribute("article") Article article) {
        System.out.println(article.getContent());
        Integer num = articleMapper.findArticleById(article.getId(),article.getUtoken());
        if (num > 0){
            articleMapper.updateArticle(article.getUtoken(),article.getId(),article.getTitle(),article.getContent(),article.getModifytime());
            return new Msg(200,article.getId());
        }
        else
        {
            articleMapper.addArticle(article);
            return new Msg(200,article.getId());
        }
    }


    /**
     * 删除文章
     * @param utoken 文章token
     * @return status
     */
    @PostMapping("del")
    public Msg delArticleByToken(@RequestParam("id") long id,@RequestParam("utoken") String utoken){
        System.out.println("刪除數據："+id);
        Integer num = articleMapper.updateArticleStatus(utoken,id,-1);
        if (num > 0){
            return new Msg(200,1);
        }
        return new Msg(0,0);
    }

    /**
     * 恢复已经删除的文章
     * @param token 文章token
     * @return status

    @GetMapping("recover")
    public Status recoverArticleByToken(@RequestParam("token") String token){
        Integer num = articleMapper.updateArticleStatus(1,token);
        if (num > 0){
            return new Status(200,new String[]{"恢复成功"});
        }
        return new Status(0,new String[]{"恢复失败"});
    }
    */

    /**
     * 彻底删除文章
     * @param token 文章token
     * @return status

    @DeleteMapping("redel")
    public Status realDelArticleByToken(@RequestParam("token") String token){
        Integer num = articleMapper.updateArticleStatus(0,token);
        if (num > 0){
            return new Status(200,Msg("删除成功",""));
        }
        return new Status(0,new String[]{"删除失败"});
    }
     */

    /**
     * 获取文章列表
     * @param utoken 用户token
     * @return 文章列表
     */
    @GetMapping("list")
    public List<ArticleList> getArtilceList(@RequestParam("utoken") String utoken){
        List<Article> articles = articleMapper.getArticleList(utoken,1);
        List<ArticleList> articleList = new ArrayList<ArticleList>();
        for (Article article : articles) {
            long id = article.getId();
            String title = article.getTitle();
            Date modifytime = article.getModifytime();
            articleList.add(new ArticleList(article.getId(),article.getTitle(),article.getModifytime()));
            System.out.println("id:"+id+"|title:"+title+"|modifytime:"+modifytime);
        }
        return articleList;
    }

    /**
     * 获取回收站列表
     * @param utoken
     * @return 文章列表
     */
    @GetMapping("recycle")
    public List<Article> getRecycleList(@RequestParam("utoken") String utoken){
        return articleMapper.getArticleList(utoken,-1);
    }

}
