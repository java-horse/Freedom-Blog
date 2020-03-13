package com.web.blog.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;


/**
 * @author mabin
 * @date 2020/2/14 20:43
 * 异常处理工具类MyExceptionHandler
 */
@ControllerAdvice  //增强型控制器
public class MyExceptionHandler {

    //获取日志对象logger(固定方式)
   private final Logger logger = LoggerFactory.getLogger(MyExceptionHandler.class);
    /**
     * 获取logger打印异常日志信息，并跳转自定义错误页面
     * @param e
     * @param request
     * @return
     */
    @ExceptionHandler(value = Exception.class)  //指定拦截的异常
    public ModelAndView handlerException(Exception e, HttpServletRequest request) {

        //设置发生异常时日志打印信息
        logger.error("request url: {},exception e : {}", request.getRequestURL(), e);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("url", request.getRequestURL());
        modelAndView.addObject("exception", e);
        modelAndView.setViewName("error/error");  //发生异常的跳转路径
        return modelAndView;

    }
}
