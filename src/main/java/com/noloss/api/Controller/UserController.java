package com.noloss.api.Controller;

import com.noloss.api.JsonFormat.Content;
import com.noloss.api.JsonFormat.Status;
import com.noloss.api.Model.User;
import com.noloss.api.Service.UserService;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.io.UnsupportedEncodingException;


/**
 * 关于用户的相关操作
 * 1.用户登陆 login
 * 2.修改密码 resetPass
 * 3.注册功能 register
 */

@RestController
@RequestMapping("user")
public class UserController{

    @Autowired
    private UserService userService;

    private static final Logger logger = LogManager.getLogger("UserController");

    //用户登陆接口
    @PostMapping("login")
    public Status login(@RequestParam(value = "user",defaultValue = "null") String user,@RequestParam(value = "pass",defaultValue = "null") String pass) throws UnsupportedEncodingException {
        if (userService.userCheck(user, pass) > 0){
            String token = userService.updateStatus(user); //记录用户token及登录信息 return boolean
            logger.info("["+user+"]登陆成功");
            return new Status(200,new Content("登陆成功",token));
        }
        return new Status(0,new Content("登陆失败",""));

        /**
         * 待实现
         * @TODO Session功能
         * 1.生成utoken功能 done
         * 生成新的token返回并插入到数据库 done
         * 2.Session功能 *
         *
         */
    }

    // 用户修改密码接口
    @PutMapping("resetPass")
    public Status resetPass(@RequestParam(value = "user",defaultValue = "null") String user,@RequestParam(value = "pass",defaultValue = "null") String pass,@RequestParam(value = "newpass",defaultValue = "null") String newpass) throws UnsupportedEncodingException {

        if (pass.equals(newpass))
        {
            return new Status(0,new Content("新密码与旧密码相同",""));
        }

        Integer num = userService.userCheck(user, pass);

        if (num <= 0)
        {
            return new Status(0,new Content("用户不存在",""));
        }

        num = userService.userCheck(user, pass);

        if (num <= 0)
        {
            return new Status(0,new Content("修改失败",""));
        }

        return new Status(200,new Content("修改成功",""));
    }

    // 检查邀请码
    @PostMapping("checkCode")
    private Status checkCode(@RequestParam(value = "inviteCode",defaultValue = "null") String InviteCode)
    {
        if (userService.checkInviteCode(InviteCode) > 0)
        {
            return new Status(200,null);
        }
        return new Status(0,null);
    }

    // 用户注册
    @PostMapping("reg")
    public Status register(@RequestParam(value = "user",defaultValue = "null") String user,@RequestParam(value = "pass",defaultValue = "null") String pass, @RequestParam(value = "inviteCode",defaultValue = "null") String InviteCode) throws UnsupportedEncodingException {
        if (userService.checkInviteCode(InviteCode) <= 0)
        {
            return new Status(0,null);
        }

        if (userService.checkUserDuplication(user) > 0)
        {
            return new Status(-1,null);
        }

        if (userService.userRegister(user,pass) <= 0){
            return new Status(-2,null);
        }

        return new Status(200,null);
    }

    //获取用户验证码
    @RequestMapping("getInviteCode")
    public Status getInviteCode(@RequestParam(value = "token",defaultValue = "null") String token){
        User user =  userService.getInviteCode(token);
        if(user != null){
            return new Status(200,new Content(user.getInviteCode(),""));
        }
        return new Status(0,null);

    }
}
