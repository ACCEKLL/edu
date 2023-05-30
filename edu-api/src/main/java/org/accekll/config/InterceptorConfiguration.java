package org.accekll.config;

import org.accekll.interceptor.MyInterceptor;
import org.accekll.interceptor.MyInterceptor2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class InterceptorConfiguration implements WebMvcConfigurer {

    @Autowired
    private MyInterceptor myInterceptor;

    @Autowired
    private MyInterceptor2 myInterceptor2;

//    @Override
//    public void addInterceptors(InterceptorRegistry registry) {
//        registry.addInterceptor(this.myInterceptor).
//                addPathPatterns("/**").
//                excludePathPatterns("/login.html",
//                        "/loginjs.js",
//                        "/logincss.css",
//                        "/lib/**",
//                        "/login",
//                        "/users/**",
//                        "/exit");
//        registry.addInterceptor(this.myInterceptor2).
//                addPathPatterns("/users/**","/exit");
//
//    }
}
