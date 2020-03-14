package com.web.blog.utils;

import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;

/**
 * @author mabin
 * @date 2020/3/13 11:26
 * 自定义生成MD5工具类
 */

public class MD5ShiroUtils {

    /**
     * 用于获取前端信息和ajax请求做比对的（冗余功能，自己玩而已）
     * @param username
     * @param password
     * @return
     */
    public static String MD5Code(String username, String password) {
        String hashAlgorithName = "MD5";
        int hashInteractions = 1024;
        return new SimpleHash(hashAlgorithName,password, ByteSource.Util.bytes(username),hashInteractions).toHex();
    }

}

