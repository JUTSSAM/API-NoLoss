package com.noloss.api.Model;

import lombok.Data;

/**
 * Created by Jutssam on 2017/4/5.
 * 文章标签
 */
@Data
public class ArticleTags {
    long id;
    String tags;
    int userId;
    int status;
}
