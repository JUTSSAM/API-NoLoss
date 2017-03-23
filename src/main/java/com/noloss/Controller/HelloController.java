package com.noloss.Controller;

import com.noloss.Mapper.UserMapper;
import com.noloss.Model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 全局测试用接口
 */

@RestController
public class HelloController {

    @Autowired
    private UserMapper userMapper;

    @RequestMapping("/find")
    public User findByName() throws Exception {
        User user = userMapper.findFirst(1);
        return user;
    }


}