package com.noloss.api;

/**
 * Created by Jutssam on 2017/3/23.
 */

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class Application {

        public static void main(String[] args) {
            SpringApplication.run(Application.class, args);
        }

}
