package org.accekll.exception;


/**
 * @Author: ZKL
 * @DataTime: 2022/8/20 16:51
 * @Description: 异常信息的枚举
 **/
public enum BusinessExceptionEnum {

    FAIL_LOGIN("用户名或密码有误"),
    ACCOUNT_ALREADY_EXISTED( "用户名已被使用"),
    FAIL_DELETE_USER("删除用户失败"),
    FAIL_NEW_USER("新增用户失败"),
    FAIL_UPDATE_USER("更新用户失败"),
    ACCOUNT_NOT_EXISTED("用户名不存在"),
    NOT_LOGIN(-2,"未登录"),
    PASSWORD_INCORRECT("密码错误");



    private Integer code;

    private String msg;

    BusinessExceptionEnum(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    BusinessExceptionEnum(String msg) {
        this.code = -1;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
