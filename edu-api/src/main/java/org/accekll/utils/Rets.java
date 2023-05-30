package org.accekll.utils;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.accekll.exception.BusinessException;
import org.apache.shiro.authc.AuthenticationException;


/**
 * @Author: ZKL
 * @DataTime: 2022/8/20 17:21
 * @Description:
 **/
public class Rets {

    public static Ret<?> success() {
        return new Ret<>(1, "操作成功", null, null, null);
    }

    public static Ret<?> loginSuccess(String token) {
        return new Ret<>(2, null, null, null, token);
    }

    public static Ret<?> resultList(Page<?> page) {
        return new Ret<>(0, null, page.getRecords(), page.getTotal(), null);
    }

    public static Ret<?> fail(BusinessException exception) {
        return new Ret<>(exception.getCode(), exception.getMessage(), null, null, null);
    }

    public static Ret<?> failLogin(AuthenticationException exception) {
        return new Ret<>(-2, exception.getMessage(), null, null, null);
    }

}
