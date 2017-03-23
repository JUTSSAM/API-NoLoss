package com.noloss.Mapper;

import com.noloss.Model.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface UserMapper {

    /**
     * 测试用
     * @param id 用户id
     * @return 用户信息
     */
    @Select("SELECT * FROM noloss_users WHERE id = #{id}")
    User findFirst(@Param("id") long id);


    /**
     * 登陆用sql
     * @param user 用户名
     * @param pass 密码
     * @return 符合用户数量
     */
    @Select("SELECT COUNT(*) FROM noloss_users WHERE user = #{user} and pass = #{pass}")
    Integer findUser(@Param("user") String user,@Param("pass") String pass);


    /**
     * 修改用户密码
     * @param user 用户名
     * @param newpass 新的密码
     * @return 修改信息
     */
    @Update("UPDATE noloss_users SET pass = #{newpass} WHERE user = #{user}")
    Integer updatePass(@Param("user") String user,@Param(("newpass")) String newpass);
}
