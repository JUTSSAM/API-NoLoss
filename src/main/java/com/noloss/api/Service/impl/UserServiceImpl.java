package com.noloss.api.Service.impl;

import com.noloss.api.Mapper.UserMapper;
import com.noloss.api.Model.Article;
import com.noloss.api.Service.Security;
import com.noloss.api.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Jutssam on 2017/4/5.
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;

    public String createUserToken(String user) throws UnsupportedEncodingException {
        SimpleDateFormat df = new SimpleDateFormat("yyyyMMdd");
        return Security.MD5encode(df+user);
    }

    public Integer userCheck(String user,String pwd) throws UnsupportedEncodingException {
        Integer num = userMapper.findUser(user,Security.MD5encode(pwd));
        return num;
    }

    public Integer updateToken(String user, String token, Date logTime){
        return userMapper.updateToken(user,token,logTime);
    }

    public String updateStatus(String user) throws UnsupportedEncodingException {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        String token = createUserToken(user);
        Integer num = updateToken(user,token,new Date());
        return token;
    }
}
