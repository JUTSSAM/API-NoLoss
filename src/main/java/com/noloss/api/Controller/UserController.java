package com.noloss.api.Controller;

import com.noloss.api.JsonFormat.Content;
import com.noloss.api.JsonFormat.Status;
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
 * 3.*注册功能
 */

@RestController
@RequestMapping("user")
public class UserController{

    @Autowired
    private UserService userService;

    private static final Logger logger = LogManager.getLogger("UserController");

    /**
     * 用户登陆接口
     * 使用get方法
     * @param user 用户名
     * @param pass 密码
     * @return 用户登陆状态(json)
     */
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
         * 1.生成utoken功能 done
         * 生成新的token返回并插入到数据库 done
         * 2.Session功能 *
         *
         */
    }


    /**
     * 用户修改密码接口
     * 使用PUT方法
     * @param user 用户名
     * @param pass 旧密码
     * @param newpass 新密码
     * @return 修改状态信息
     */
    @PutMapping("resetPass")
    public Status resetPass(@RequestParam(value = "user",defaultValue = "null") String user,@RequestParam(value = "pass",defaultValue = "null") String pass,@RequestParam(value = "newpass",defaultValue = "null") String newpass) throws UnsupportedEncodingException {

        if (pass.equals(newpass)){
            return new Status(0,new Content("新密码与旧密码相同",""));
        }

        Integer num = userService.userCheck(user, pass);
        if (num <= 0){
            return new Status(0,new Content("用户不存在",""));
        }

        num = userService.userCheck(user, pass);
        if (num <= 0){
            return new Status(0,new Content("修改失败",""));
        }

        return new Status(200,new Content("修改成功",""));
    }

}
