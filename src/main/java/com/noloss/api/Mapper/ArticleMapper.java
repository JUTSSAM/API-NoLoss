package com.noloss.api.Mapper;

import com.noloss.api.Model.Article;
import com.noloss.api.Model.User;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.StatementType;

import java.sql.Timestamp;
import java.util.List;

@Mapper
public interface ArticleMapper {

    /**
     * 关于文章的数据库操作
     * 1.获取文章内容
     * 2.添加新的文章
     * 3.修改文章状态
     * 4.获取文章列表
     */

    /**
     * 删除/恢复/彻底删除 文章接口
     * 1 使用中
     * -1 已删除（回收站）
     * 0 彻底删除
     * @param userId 用户id
     * @return 修改行数
     */
    @Update("UPDATE noloss_articles SET status = #{status} WHERE userId = #{userId} and id = #{id}")
    Integer updateArticleStatus(@Param("userId") long userId,@Param("id") long id,@Param("status") Integer status);

    // 根据文章的id获取文章内容
    @Select("SELECT * FROM noloss_articles WHERE id = #{id} and userId = #{userId} and status = 1")
    Article getArticleById(@Param("id") long id,@Param("userId") long userId);

    //验证文章是否存在
    @Select("SELECT COUNT(*) FROM noloss_articles WHERE id = #{id} and userId = #{userId} and status = 1")
    Integer findArticleById(@Param("id") long id,@Param("userId") long userId);

    //添加新文章接口
    @Insert("INSERT INTO noloss_articles (userId,title,content,createtime,modifytime) VALUES(#{article.userId},#{article.title},#{article.content},#{article.modifytime},#{article.modifytime})")
    @SelectKey(keyProperty = "article.id",before = false,resultType = Integer.class,statementType= StatementType.STATEMENT,statement="SELECT LAST_INSERT_ID() AS id")
    long addArticle(@Param("article") Article article);

    //修改文章接口
    @Update("UPDATE noloss_articles SET title = #{title},content = #{content},modifytime = #{modifytime} WHERE userId = #{userId} and id = #{id}")
    Integer updateArticle(@Param("userId") long userId,@Param("id") long id,@Param("title") String title,@Param("content") String content,@Param("modifytime") Timestamp modifytime);

    //获取文章列表
    @Select("SELECT " +
            "article.id,article.title,article.modifytime " +
            "FROM noloss_articles as article " +
            "LEFT JOIN noloss_users as user on article.userId = user.id " +
            "WHERE user.token = #{utoken} and article.status = #{status}")
    List<Article> getArticleLists(@Param("utoken") String utoken, @Param("status") Integer status);

    //获取文章内容
    @Select("SELECT " +
            "article.* " +
            "FROM noloss_articles as article " +
            "LEFT JOIN noloss_users as user on article.userId = user.id " +
            "WHERE user.token = #{utoken} and article.id = #{id} and article.status = 1")
    Article getArticle(@Param("id") long id,@Param("utoken") String utoken);

    //根据token获取用户信息
    @Select("SELECT id FROM noloss_users WHERE token = #{token}")
    User SwitchTokenToId(@Param("token") String token);
}
