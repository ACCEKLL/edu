package org.accekll.security;


import org.accekll.pojo.User;
import org.accekll.service.UserService;
import org.accekll.utils.EhCacheUtil;
import org.accekll.utils.HttpUtil;
import org.accekll.utils.JwtUtil;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author: ZKL
 * @DataTime: 2022/9/3 15:17
 * @Description:
 **/
@Service
public class UserRealm extends AuthorizingRealm {

    @Autowired
    private EhCacheUtil ehCacheUtil;

    @Autowired
    private UserService userService;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        System.out.println("授权........");
        User user = userService.getByLoginName(JwtUtil.getUsername(HttpUtil.getToken()));
        String role = user.getRole();
        Set<String> permsList= new HashSet<>();
        permsList.add(role);
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        authorizationInfo.setStringPermissions(permsList);
        return authorizationInfo;
    }


    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException{
        System.out.println("认证........");
        String token = (String) authenticationToken.getCredentials();
        String flag = ehCacheUtil.getToken(token);
        if(flag == null){
            throw new AuthenticationException("未登录");
        }
        return new SimpleAuthenticationInfo(token, token, "myRealm");
    }

    @Override
    public boolean supports(AuthenticationToken token) {
        return token instanceof MyToken;
    }


}
