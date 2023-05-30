package org.accekll.exception;

import org.accekll.utils.Ret;
import org.accekll.utils.Rets;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @Author: ZKL
 * @DataTime: 2022/8/20 21:59
 * @Description: 异常处理
 **/
@RestControllerAdvice
public class ExceptionHandle {

    @ExceptionHandler(BusinessException.class)
    public Ret<?> handle(BusinessException exception) {
        return Rets.fail(exception);
    }

//    @ExceptionHandler(AuthenticationException.class)
//    public Ret<?> handleLogin(AuthenticationException exception) {
//        return Rets.failLogin(exception);
//    }

}
