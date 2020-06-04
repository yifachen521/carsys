package com.qf.realm;

import com.qf.pojo.SysUser;
import com.qf.service.UserService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author 炜哥哥
 * @date 2020/1/16 8:15
 */

public class MyRealm extends AuthorizingRealm {

    @Autowired
    private UserService userService;
    //授权
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        return null;
    }
    //身份认证
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        UsernamePasswordToken authenticationToken1 = (UsernamePasswordToken) authenticationToken;
        String username = ((UsernamePasswordToken) authenticationToken).getUsername();
        //去数据库查询该用户是否存在
        SysUser sysUser = userService.clickLogin(username);
        System.out.println(sysUser.toString()+"111---");
        if (sysUser!=null){
            //用户存在
            return new SimpleAuthenticationInfo(sysUser,sysUser.getPassword(),"MyRealm");
        }
        return null;
    }
}
