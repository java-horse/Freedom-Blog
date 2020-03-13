package com.web.blog.config;


import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

/**
 * @author mabin
 * @date 2020/3/2 13:18
 * 配置：DruidDataSource数据源生效的扩展类(替换springboot中默认的数据源，使配置文件中的druid配置生效)
 */
@Configuration
public class MyDruidConfig {

    @Bean
    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSource dataSource() {
        return new DruidDataSource();
    }
}
