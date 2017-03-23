package com.noloss.Mapper;

import com.noloss.Model.Article;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface ArticleMapper {

    /**
     * 根据文章的id获取文章内容
     *
     * @param id 文章id
     * @return 文章信息
     */
    @Select("SELECT * FROM noloss_articles WHERE id = #{id}")
    Article getArticleById(@Param("id") long id);


//    @Update("UPDATE noloss_articles SET ")
}
