package com.web.blog.base;

import org.apache.commons.lang3.StringUtils;

/**
 * @author mabin
 * @date 2020/4/14 12:59
 */

public enum BlogKeys {

    BLOG("blog:"),
    TYPE("type:"),
    TAG("tag:"),
    USER("user:"),


    VIEW(":views");

    private String keyName;

    BlogKeys(String keyName) {
        this.keyName = keyName;
    }

    /**
     * 获取key：用于标识redis
     *
     * @param keyName
     * @return
     */
    public static String getKey(String keyName) {
        for (BlogKeys value : BlogKeys.values()) {
            if (StringUtils.equals(keyName, value.name())) {
                return value.keyName;
            }
        }
        return null;
    }


}
