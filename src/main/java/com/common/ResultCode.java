package com.common;

public enum ResultCode {
    SUCCESS_NULL(0, "成功, 但结果为null"), //成功, 但结果为null
    SUCCESS(1, "成功"),
//    500错误
    SYSTEM_ERROR(10000, "系统异常,请求稍后重试"),
    PARAM_IS_INVALID(10401, "参数无效"),
    USER_HAS_EXISTED(20001,"用户名已存在"),
    USER_NOT_FIND(20002,"用户名不存在");

    private Integer status;
    private String msg;

    ResultCode(int status, String statusText) {
        this.status = status;
        this.msg = statusText;
    }

    public Integer getStatus() {
        return status;
    }

    public String getMsg() {
        return  msg;
    }

}
