package com.noloss.api.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Jutssam on 2017/4/5.
 */

@Controller
public class IndexController {
    @RequestMapping("/")
    public String index(Model model){
        return "index";
    }
}
