package org.accekll.security;

import org.apache.shiro.authc.AuthenticationToken;

/**
 * @Author: ZKL
 * @DataTime: 2022/9/7 15:10
 * @Description:
 **/
public class MyToken implements AuthenticationToken {

    private String token;

    public MyToken(String token) {
        this.token = token;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    @Override
    public Object getPrincipal() {
        return token;
    }

    @Override
    public Object getCredentials() {
        return token;
    }
}
