package com.web.blog.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author mabin
 * @date 2020/3/23 12:37
 * 资源路径映射
 */
@Configuration
public class MyWebMvcConfig implements WebMvcConfigurer {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/static/images/editorImages/**")
                .addResourceLocations("file:D:/IEDA_data/springboot-web-bolg/src/main/resources/static/images/editorImages/");
    }
}
