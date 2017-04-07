package com.noloss.api.Model;

import lombok.Data;

/**
 * Created by Jutssam on 2017/4/5.
 * 文章分组
 */
@Data
public class ArticleGroup {
    long id;
    String group;
    int userId;
    int status;
}
