package com.noloss.api.Controller;

import com.noloss.api.Mapper.ArticleMapper;
import com.noloss.api.Model.Article;
import com.noloss.api.Model.Status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    /**
     * 根据文章token获取文章内容
     * @param token 文章token
     * @param utoken 用户token
     * @return 文章内容
     */
    @GetMapping("Get")
    public Article getArticleByToken(@RequestParam("token") String token,@RequestParam("utoken") String utoken){
        return articleMapper.getArticleByToken(token,utoken);
    }


    /**
     * 删除文章
     * @param token 文章token
     * @return status
     */
    @DeleteMapping("del")
    public Status delArticleByToken(@RequestParam("token") String token){
        Integer num = articleMapper.updateArticleStatus(-1,token);
        if (num > 0){
            return new Status(200,"删除成功");
        }
        return new Status(0,"删除失败");
    }

    /**
     * 恢复已经删除的文章
     * @param token 文章token
     * @return status
     */
    @GetMapping("recover")
    public Status recoverArticleByToken(@RequestParam("token") String token){
        Integer num = articleMapper.updateArticleStatus(1,token);
        if (num > 0){
            return new Status(200,"恢复成功");
        }
        return new Status(0,"恢复失败");
    }

    /**
     * 彻底删除文章
     * @param token 文章token
     * @return status
     */
    @DeleteMapping("redel")
    public Status realDelArticleByToken(@RequestParam("token") String token){
        Integer num = articleMapper.updateArticleStatus(0,token);
        if (num > 0){
            return new Status(200,"彻底删除成功");
        }
        return new Status(0,"删除失败");
    }

    /**
     * 获取文章列表
     * @param utoken 用户token
     * @return 文章列表
     */
    @GetMapping("list")
    public List<Article> getArtilceList(@RequestParam("utoken") String utoken){
        return articleMapper.getArticleList(utoken,1);
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
