package com.noloss.api.Mapper;

import com.noloss.api.JsonFormat.ArticleList;
import com.noloss.api.Model.Article;
import org.apache.ibatis.annotations.*;

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
     * 根据文章的id获取文章内容
     *
     * @param id 文章id
     * @return 文章信息
     */
    @Select("SELECT * FROM noloss_articles WHERE id = #{id} and utoken = #{utoken} and status = 1")
    Article getArticleById(@Param("id") long id,@Param("utoken") String utoken);

    @Select("SELECT COUNT(*) FROM noloss_articles WHERE id = #{id} and utoken = #{utoken} and status = 1")
    Integer findArticleById(@Param("id") long id,@Param("utoken") String utoken);
    /**
     * 根据文章的token获取文章内容
     *
     * @param token 文章token
     * @return 文章信息
     */
    @Select("SELECT * FROM noloss_articles WHERE token = #{token} and utoken = #{utoken} and status = 1")
    Article getArticleByToken(@Param("token") String token,@Param("utoken") String utoken);

    /**
     * 添加新文章接口
     * @param title 标题
     * @param content 正文
     * @param utoken 用户口令
     * @param createtime 创建时间
     * @param modifytime 修改时间
     * @return 修改行数
     */
    @Insert("INSERT INTO noloss_articles (title,abstra,content,utoken,createtime,modifytime) VALUES(#{title},#{title},#{content},#{utoken},#{createtime},#{modifytime})")
    Integer addArticle(@Param("title") String title, @Param("content") String content, @Param("utoken") String utoken, @Param("createtime") Timestamp createtime, @Param("modifytime") Timestamp modifytime);

    @Update("UPDATE noloss_articles SET title = #{title},content = #{content},modifytime = #{modifytime} WHERE utoken = #{utoken} and id = #{id}")
    Integer updateArticle(@Param("utoken") String utoken,@Param("id") long id,@Param("title") String title,@Param("content") String content,@Param("modifytime") Timestamp modifytime);

    /**
     * 删除/恢复/彻底删除 文章接口
     * 1 使用中
     * -1 已删除（回收站）
     * 0 彻底删除
     * @param utoken 文章口令
     * @return 修改行数
     */
    @Update("UPDATE noloss_articles SET status = #{status} WHERE utoken = #{utoken} and id = #{id}")
    Integer updateArticleStatus(@Param("utoken") String utoken,@Param("id") long id,@Param("status") Integer status);

    /**
     * 获取文章列表
     * @param utoken
     * @param status
     * @return 标题，概述，创建时间，最后修改时间
     */
    @Select("SELECT id,title,modifytime FROM noloss_articles WHERE utoken = #{utoken} and status = #{status}")
    List<Article> getArticleList(@Param("utoken") String utoken, @Param("status") Integer status);
}
