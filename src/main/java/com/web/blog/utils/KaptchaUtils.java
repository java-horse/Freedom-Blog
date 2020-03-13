package com.web.blog.utils;

import javax.servlet.http.HttpServletRequest;

/**
 * @author mabin
 * @date 2020/3/12 12:28
 * 验证码比对工具类
 */

public class KaptchaUtils {

    /**
     * 将获取到的前端参数转为string类型
     * @param request
     * @param key
     * @return
     */
    public static String getString(HttpServletRequest request, String key) {
        try {
            //获取用户输入的验证码并转化层字符串
            String result = request.getParameter(key);
            if(result != null) {
                result = result.trim();
            }
            if("".equals(result)) {
                result = null;
            }
            return result;
        }catch(Exception e) {
            return null;
        }
    }
    /**
     * 验证码校验
     * @param request
     * @return
     */
    public static boolean checkVerifyCode(HttpServletRequest request) {
        //获取生成的验证码
        String verifyCodeExpected = (String) request.getSession().getAttribute(com.google.code.kaptcha.Constants.KAPTCHA_SESSION_KEY);
        //获取用户输入的验证码并进行比对操作
        String verifyCodeActual = KaptchaUtils.getString(request, "kaptcha");
        if (verifyCodeActual == null || !verifyCodeActual.equals(verifyCodeExpected)) {
            return false;
        }
        return true;
    }
}

