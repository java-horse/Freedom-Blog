package com.web.blog.mapper;

import com.web.blog.bean.User;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author mabin
 * @date 2020/2/15 15:03
 */
@Mapper
@Repository
public interface LoginMapper {

    /**
     * 查询用户
     *
     * @param username
     * @return
     */
    @Select("SELECT * FROM t_user WHERE username=#{username}")
    public User findUserByUsername(String username);

    @Select("SELECT * FROM t_user limit 0,1")
    public User findUser();

    @Insert("update t_user set nickname=#{nickname},username=#{username},password=#{password},email=#{email} where id=#{id}")
    @Transactional
    int updateAdmin(User user);

    @Update("update t_user set avatar=#{avatarURL} where id=#{userId}")
    @Transactional
    void updateUserAvatar(@Param("userId") Integer id, @Param("avatarURL") String avatarURL);
}
