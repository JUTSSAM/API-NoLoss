package com.noloss.api.Mapper;

import com.noloss.api.Model.Article;
import org.apache.ibatis.annotations.*;

@Mapper
public interface ArticleMapper {

    /**
     * 关于文章的数据库操作
     * 1.获取文章内容
     * 2.添加新的文章
     */



    /**
     * 根据文章的id获取文章内容
     *
     * @param id 文章id
     * @return 文章信息
     */
    @Select("SELECT * FROM noloss_articles WHERE id = #{id} and utoken = #{utoken}")
    Article getArticleById(@Param("id") long id,@Param("utoken") String utoken);


    /**
     * 添加新文章接口
     * @param title 标题
     * @param abstra 概述
     * @param content 正文
     * @param token 文章口令
     * @param utoken 用户口令
     * @param createtime 创建时间
     * @param modifytime 修改时间
     * @return 修改行数
     */
    @Insert("INSERT INTO noloss_articles (title,abstra,content,token,utoken,createtime,modifytime) VALUES(#{title},#{abstra},#{content},#{token},#{utoken},#{createtime},#{modifytime})")
    Integer addArticle(@Param("title") String title,@Param("abstra") String abstra,@Param("content") String content,@Param("token") String token,@Param("utoken") String utoken,@Param("createtime") String createtime,@Param("modifytime") String modifytime);

    //    @Update("UPDATE noloss_articles SET ")
}
