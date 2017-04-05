package com.noloss.api.Model;

import lombok.Data;

/**
 * 用户
 */
@Data
public class User {
    private long id;
    private String user;
    private String pass;
    private String token;
}
