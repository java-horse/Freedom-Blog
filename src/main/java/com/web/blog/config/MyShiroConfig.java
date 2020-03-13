package com.web.blog.config;

import at.pollux.thymeleaf.shiro.dialect.ShiroDialect;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author mabin
 * @date 2020/2/15 16:49
 */
@Configuration
public class MyShiroConfig {

    @Bean
    public MyShiroRealm myShiroRealm() {
        return new MyShiroRealm();
    }

    @Bean
    public DefaultWebSecurityManager defaultWebSecurityManager(@Qualifier("myShiroRealm") MyShiroRealm myShiroRealm) {
        DefaultWebSecurityManager manager = new DefaultWebSecurityManager();
        manager.setRealm(myShiroRealm);
        return manager;
    }

    @Bean
    public ShiroFilterFactoryBean shiroFilterFactoryBean(@Qualifier("defaultWebSecurityManager") DefaultWebSecurityManager defaultWebSecurityManager) {
        ShiroFilterFactoryBean bean = new ShiroFilterFactoryBean();
        /*设置安全管理器*/
        bean.setSecurityManager(defaultWebSecurityManager);

        Map<String, String> filterMap = new LinkedHashMap<>();
        /*可以直接访问（不拦截认证的路径）*/
        filterMap.put("/admin/login","anon");
        filterMap.put("/admin/unauthorized","anon");
        filterMap.put("/admin/userPass","anon");
        /*需要认证的路径*/
        filterMap.put("/admin/**", "authc");
        /*获取会添加需要访问权限的路径（未完待续...）(filterMap.put("/test/*", "perms[user:admin]");)*/

        bean.setFilterChainDefinitionMap(filterMap);

        bean.setLoginUrl("/admin");
        /*当前数据库设计暂时不会触发该配置*/
        bean.setUnauthorizedUrl("/admin/unauthorized");
        return bean;

    }

    /**
     * 整合ShiroDialect：避免整合thymeleaf和shiro报错
     * @return
     */
    @Bean
    public ShiroDialect shiroDialect() {
        return new ShiroDialect();
    }

}
