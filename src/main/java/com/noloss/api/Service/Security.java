package com.noloss.api.Service;

import sun.misc.BASE64Encoder;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * 生成token函数
 * 密码加密函数
 */
public class Security {
    protected static String md5(String str) throws UnsupportedEncodingException {
        MessageDigest md5 = null;
        try {
            md5 = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        BASE64Encoder base64en = new BASE64Encoder();
        String md5Str = base64en.encode(md5.digest(str.getBytes("utf-8")));
        System.out.println("MD5: " + md5Str + " len=" + md5Str.length());
        return md5Str;
    }

    public static String MD5encode(String Str) throws UnsupportedEncodingException {
        return md5(Str);
    }
}
