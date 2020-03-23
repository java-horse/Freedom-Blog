package com.web.blog.config;

import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.unit.DataSize;

import javax.servlet.MultipartConfigElement;

/**
 * @author mabin
 * @date 2020/3/23 12:35
 * 设置：文件上传大小
 */
@Configuration
public class MyFileUploadConfig {

        @Bean
        public MultipartConfigElement multipartConfigElement() {
            MultipartConfigFactory factory = new MultipartConfigFactory();
            //单个文件最大KB,MB
            factory.setMaxFileSize(DataSize.parse("10MB"));
            //设置总上传数据总大小
            factory.setMaxRequestSize(DataSize.parse("20MB"));
            return factory.createMultipartConfig();
        }

}
