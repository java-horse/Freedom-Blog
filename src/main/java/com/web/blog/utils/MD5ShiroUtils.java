package com.web.blog.utils;

import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;

/**
 * @author mabin
 * @date 2020/3/13 11:26
 */

public class MD5ShiroUtils {

    public static String MD5Code(String username, String password) {
        String hashAlgorithName = "MD5";
        int hashInteractions = 1024;
        return new SimpleHash(hashAlgorithName,password, ByteSource.Util.bytes(username),hashInteractions).toHex();
    }

}

