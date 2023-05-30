package org.accekll.controller;


import org.accekll.exception.BusinessException;
import org.accekll.exception.BusinessExceptionEnum;
import org.accekll.pojo.User;
import org.accekll.service.UserService;
import org.accekll.utils.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;


@Controller
@RequestMapping()
public class LoginController {

    @Autowired
    private EhCacheUtil ehCacheUtil;

    @Autowired
    private UserService userService;

    @ResponseBody
    @GetMapping("/login")
    public Ret<?> login(User user) {
        System.out.println("正在登录....");
        String loginName = user.getLoginName();
        String password = user.getPassword();
        User loginUser = userService.getByLoginName(loginName);
        if (userService.getByLoginName(loginName) == null) {
            throw new BusinessException(BusinessExceptionEnum.ACCOUNT_NOT_EXISTED);
        }
        if (!MD5.md5(password, loginUser.getSalt()).equals(loginUser.getPasswordPro())) {
            throw new BusinessException(BusinessExceptionEnum.PASSWORD_INCORRECT);
        }
        String token = JwtUtil.sign(loginUser, 1000 * 60 * 5);
        ehCacheUtil.setToken(token);
        System.out.println("登录成功....");
        return Rets.loginSuccess(token);
    }

    @ResponseBody
    @GetMapping("/logout")
    public void logout(HttpServletRequest httpServletRequest) {
        String token = httpServletRequest.getHeader("token");
        System.out.println(ehCacheUtil.removeToken(token));
    }

//    @GetMapping("/")
//    public String mainPage() {
//        return "login.html";
//    }

}
