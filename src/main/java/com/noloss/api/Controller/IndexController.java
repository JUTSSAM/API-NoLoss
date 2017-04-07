package com.noloss.api.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Jutssam on 2017/4/5.
 */

@RestController
public class IndexController {
    @RequestMapping("/")
    public String index(Model model){
        return "RESTful API for App NoLoss.";
    }
}
