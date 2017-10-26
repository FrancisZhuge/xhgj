package com.dou.xhgj.realm;

import com.dou.xhgj.domain.UserInfo;
import com.dou.xhgj.service.permission.UserService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @Author: Francis Zhuge
 * @Description: 权限角色类
 * @Date: Created in 2017/10/20, 21:44
 * @Modified By:
 * @Email: franciszhuge@163.com
 */
public class UserRealm extends AuthorizingRealm{
    @Autowired
    private UserService userService;

    /**
     * 设置用户的角色和权限
     * @param principals
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        String username = (String)principals.getPrimaryPrincipal();
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        authorizationInfo.setRoles(userService.findRoleswithAvailable(username));
        authorizationInfo.setStringPermissions(userService.findPermissions(username));
        return null;
    }

    /**
     * 验证用户
     * @param token
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        String username = (String) token.getPrincipal();
        UserInfo userInfo = userService.getByUsername(username);
        //没有找到账号
        if(userInfo == null){
            throw new UnknownAccountException();
        }
        //账号锁定
        if(Boolean.TRUE.equals(userInfo.getLocked())){
            throw new LockedAccountException();
        }

        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(
                userInfo.getUsername(),
                userInfo.getPassword(),
                ByteSource.Util.bytes(userInfo.getCredentialsSalt()),//salt=username+salt
                getName()  //realm name
        );
        return authenticationInfo;
    }
}
