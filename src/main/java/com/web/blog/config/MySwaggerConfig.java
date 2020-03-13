package com.web.blog.config;

import io.swagger.annotations.Api;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.core.env.Profiles;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author mabin
 * @date 2020/2/15 13:24
 */

@Api("Swagger配置类")
@EnableSwagger2
@Configuration
public class MySwaggerConfig {

        @Bean
        public Docket docket(Environment environment) {

            /*判断当前环境是否是dev环境*/
            Profiles profiles = Profiles.of("dev");
            boolean flag = environment.acceptsProfiles(profiles);

            return new Docket(DocumentationType.SWAGGER_2)
                    .enable(flag)
                    .apiInfo(apiInfo())
                    .groupName("horse")
                    .select().apis(RequestHandlerSelectors.basePackage("com.web.blog.controller"))
                    .build();
        }

        /**
         * 用于被Docket调用的配置方法
         * @return
         */
        public ApiInfo apiInfo() {
            return new ApiInfoBuilder()
                    .title("麋鹿滨API接口文档")
                    .description("自我测试")
                    .version("v2.0")
                    .contact(new Contact("mabin", "http://www.baidu.com", "34684499362@qq.com"))
                    .licenseUrl("http://www.baidu.com")
                    .license("What ？")
                    .build();
        }
}
