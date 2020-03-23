package com.web.blog.utils;

import javax.servlet.http.HttpServletRequest;

/**
 * @author mabin
 * @date 2020/3/23 16:22
 * 动态获取站点路径
 */

public class FileUploadUtils {

    public static String getImagePath(HttpServletRequest request){
        String scheme = request.getScheme(); // 获取链接协议，http
        String serverName = request.getServerName(); // 获取服务器名称 localhost
        int serverPort = request.getServerPort(); // 获取端口 8080
        String path = scheme+"://"+serverName+":"+serverPort+"/";
        return path;
    }
}
