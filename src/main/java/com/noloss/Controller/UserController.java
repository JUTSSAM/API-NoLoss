package com.noloss.Controller;

import com.noloss.Mapper.UserMapper;
import com.noloss.Model.Status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 关于用户的相关操作
 * 1.用户登陆 login
 * 2.修改密码 resetPass
 */

@RestController
@RequestMapping("user")
public class UserController{

    @Autowired
    private UserMapper userMapper;


    /**
     * 用户登陆接口
     * 使用get方法
     * @param user 用户名
     * @param pass 密码
     * @return 用户登陆状态(json)
     */
    @GetMapping("login")
    public Status login(@RequestParam(value = "user",defaultValue = "null") String user,@RequestParam(value = "pass",defaultValue = "null") String pass){
        Integer num = userMapper.findUser(user,pass);
        if (num > 0){
            return new Status(200,"用户登陆成功");
        }
        return new Status(0,"用户名或密码错误");
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
    public Status resetPass(@RequestParam(value = "user",defaultValue = "null") String user,@RequestParam(value = "pass",defaultValue = "null") String pass,@RequestParam(value = "newpass",defaultValue = "null") String newpass){

        if (pass.equals(newpass)){
            return new Status(0,"新密码与旧密码相同");
        }

        Integer num = userMapper.findUser(user,pass);
        if (num <= 0){
            return new Status(0,"用户不存在");
        }

        num = userMapper.updatePass(user,newpass);
        if (num <= 0){
            return new Status(0,"修改失败");
        }

        return new Status(200,"修改成功");
    }

}
