package com.web.blog.service;

import com.web.blog.bean.User;

/**
 * @author mabin
 * @date 2020/2/15 15:02
 */
public interface LoginService {

    /**
     * 根据用户名：查询用户信息
     * @param username
     * @return
     */
    public User findUserByUsername(String username);

    public User findUserByPassword(String password);

}
