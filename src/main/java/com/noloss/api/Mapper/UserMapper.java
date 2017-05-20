package com.noloss.api.Mapper;

import com.noloss.api.Model.User;
import org.apache.ibatis.annotations.*;
import org.springframework.web.bind.annotation.RequestParam;

import java.text.SimpleDateFormat;
import java.util.Date;

@Mapper
public interface UserMapper {

    //测试用
    @Select("SELECT * FROM noloss_users WHERE id = #{id}")
    User findFirst(@Param("id") long id);

    //验证用户存在
    @Select("SELECT COUNT(*) FROM noloss_users WHERE user = #{user} and pass = #{pass}")
    Integer findUser(@Param("user") String user,@Param("pass") String pass);

    //修改用户密码
    @Update("UPDATE noloss_users SET pass = #{newpass} WHERE user = #{user}")
    Integer updatePass(@Param("user") String user,@Param(("newpass")) String newpass);

    // 更新登录信息
    @Update("UPDATE noloss_users SET token = #{token} , logTime = #{logTime}  WHERE user = #{user}")
    Integer updateToken(@Param("user") String user,@Param(("token")) String token,@Param("logTime") Date logTime);

    // 检测验证码是否存在
    @Select("SELECT COUNT(*) FROM noloss_users WHERE inviteCode = #{inviteCode}")
    Integer checkInviteCode(@Param("inviteCode") String inviteCode);

    //检测用户名是否重复
    @Select("SELECT COUNT(*) FROM noloss_users WHERE user = #{user}")
    Integer checkUserDupli(@Param("user") String user);

    //用户注册
    @Insert("INSERT INTO noloss_users(user,pass,nickname,inviteCode) VALUES (#{user},#{pass},#{user},#{inviteCode})")
    Integer addNewUser(@Param("user") String user,@Param("pass") String pass,@Param("inviteCode") String inviteCode);

    //获取用户验证码
    @Select("SELECT * FROM noloss_users WHERE token = #{token}")
    User getInviteCode(@Param("token") String token);
}
