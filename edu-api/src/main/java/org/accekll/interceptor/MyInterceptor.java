package org.accekll.interceptor;

import org.accekll.pojo.User;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Component
public class MyInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session = request.getSession();
        User user2 = (User) session.getAttribute("user");
        if (user2 == null) {
            System.out.println("已拦截1....");
            response.sendRedirect("/login.html");
            return false;
        }
        return true;
    }
}
