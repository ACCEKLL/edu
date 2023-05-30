package org.accekll.exception;

/**
 * @Author: ZKL
 * @DataTime: 2022/8/20 16:50
 * @Description: 业务异常类
 **/
public class BusinessException extends RuntimeException {

    private Integer code;

    private String msg;

    public BusinessException(BusinessExceptionEnum exceptionEnum) {
        this.code = exceptionEnum.getCode();
        this.msg = exceptionEnum.getMsg();
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return msg;
    }

    public void setMessage(String msg) {
        this.msg = msg;
    }
}
