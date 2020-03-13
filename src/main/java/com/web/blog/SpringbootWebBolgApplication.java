package com.web.blog;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author 马滨
 */

@MapperScan(basePackages = "com.web.blog.mapper") //使用@Mapper注解二选其一，但是这个相对简单
@EnableTransactionManagement  //启用注解式事务管理，相当于之前在xml中配置的<tx:annotation-driven />注解驱动
@SpringBootApplication
public class SpringbootWebBolgApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootWebBolgApplication.class, args);
    }

}
