package com.web.blog.service.impl;

import com.web.blog.bean.User;
import com.web.blog.mapper.LoginMapper;
import com.web.blog.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author mabin
 * @date 2020/2/15 15:11
 */
@Service
@Transactional
public class LoginServiceImpl implements LoginService {

    @Autowired
    private LoginMapper loginMapper;

    @Override
    public User findUserByUsername(String username) {
       return loginMapper.findUserByUsername(username);
    }

    @Override
    public User findUser() {
        return loginMapper.findUser();
    }

    @Override
    public int updateAdmin(User user) {
        return loginMapper.updateAdmin(user);
    }

    @Override
    public void updateUserAvatar(Integer id,String avatarURL) {
        loginMapper.updateUserAvatar(id,avatarURL);
    }

}
