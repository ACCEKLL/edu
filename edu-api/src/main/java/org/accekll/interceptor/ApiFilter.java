package org.accekll.interceptor;

import org.accekll.security.MyToken;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.web.filter.authc.BasicHttpAuthenticationFilter;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Author: ZKL
 * @DataTime: 2022/9/6 20:19
 * @Description:
 **/
public class ApiFilter extends BasicHttpAuthenticationFilter {

    @Override
    protected boolean preHandle(ServletRequest request, ServletResponse response) throws Exception {
        System.out.println("preHandle............");
        return super.preHandle(request, response);
    }

    @Override
    protected boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object mappedValue) {
        System.out.println("isAccessAllowed.....");
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;
        String httpToken = httpRequest.getHeader("token");
        System.out.println("token:" + httpToken);
        if (httpToken != null) {
            MyToken token = new MyToken(httpToken);
            try {
                SecurityUtils.getSubject().login(token);
                System.out.println("认证成功.....");
                return true;
            } catch (Exception e) {
                System.out.println("认证失败....");
            }
        }
        System.out.println("非法token.....");
        httpResponse.setStatus(401);
        return false;
    }

    @Override
    protected boolean onAccessDenied(ServletRequest request, ServletResponse response, Object mappedValue) throws Exception {
        System.out.println("onAccessDenied.......");
        return false;
    }
}
