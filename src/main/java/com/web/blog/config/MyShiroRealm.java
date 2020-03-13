package com.web.blog.config;

import com.web.blog.bean.User;
import com.web.blog.service.LoginService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author mabin
 * @date 2020/2/15 16:51
 */
public class MyShiroRealm extends AuthorizingRealm {

    @Autowired
    private LoginService loginService;

    /**
     * 授权
     * @param principals
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {

        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        Subject subject = SecurityUtils.getSubject();

        /*获取当前登录用户*/
        User currentUser = (User) subject.getPrincipal();
        /*授权当前用户相关角色（非常不合理，本次数据库设计没有涉及到角色和权限等，只是自己添加的）*/
        info.addStringPermission(currentUser.getPerms());

        return info;
    }

    /**
     * 认证
     * @param token
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {

        /*强制类型转换*/
        UsernamePasswordToken userToken = (UsernamePasswordToken) token;
        /*连接数据库：获取用户信息*/
        User currentUser = loginService.findUserByUsername(userToken.getUsername());
        if (currentUser == null) {
            return null;
        }
        Subject subject = SecurityUtils.getSubject();
        Session session = subject.getSession();
        session.setAttribute("loginUser", currentUser);

        //自定义盐值
        ByteSource salt = ByteSource.Util.bytes(currentUser.getUsername());
        /*密码Shiro框架自己认证,（MyShiroConfig配置类中自定义传入MD5加密）*/
        return new SimpleAuthenticationInfo(currentUser, currentUser.getPassword(),salt, getName());
    }
}
