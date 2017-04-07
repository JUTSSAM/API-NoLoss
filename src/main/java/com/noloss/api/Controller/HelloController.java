package com.noloss.api.Controller;

import com.noloss.api.Model.Article;
import com.noloss.api.Service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 全局测试用接口
 */

@RestController
public class HelloController {

    @Autowired
    HelloService helloService;

    @RequestMapping("/find")
    @Cacheable(value = "Article")
    public Article findByName() throws Exception {
        Article article = helloService.DemoHello(1);
        return article;
    }


}