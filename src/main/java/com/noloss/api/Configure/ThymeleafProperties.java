package com.noloss.api.Configure;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Created by Jutssam on 2017/4/5.
 */
@ConfigurationProperties("spring.thymeleaf")
public class ThymeleafProperties {
    public static final String DEFAULT_PREFIX = "classpath:/templates/";

    public static final String DEFAULT_SUFFIX = ".html";

    private String prefix = DEFAULT_PREFIX;

    private String suffix = DEFAULT_SUFFIX;

    private String mode = "HTML5";

    private String encoding = "UTF-8";

    private String contentType = "text/html";

    private boolean cache = true;

}
