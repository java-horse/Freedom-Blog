package com.web.blog.mapper;

import com.web.blog.bean.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

/**
 * @author mabin
 * @date 2020/2/15 15:03
 */
@Mapper
@Repository
public interface LoginMapper {

    /**
     * 查询用户
     * @param username
     * @return
     */
    @Select("SELECT * FROM t_user WHERE username=#{username}")
    public User findUserByUsername(String username);


}
