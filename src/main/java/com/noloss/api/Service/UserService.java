package com.noloss.api.Service;

import com.noloss.api.Model.User;

import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by ${Jutssam} on 2017/4/29.
 */
public interface UserService {
    String  createUserToken(String user) throws UnsupportedEncodingException;//生成用户token
    Integer updateToken(String user, String token, Date logTime);
    Integer userCheck(String user,String pwd) throws UnsupportedEncodingException;
    String  updateStatus(String user) throws UnsupportedEncodingException;
    Integer checkInviteCode(String code);
    Integer checkUserDuplication(String user);
    Integer userRegister(String user,String pass);
    User getInviteCode(String token);
}
