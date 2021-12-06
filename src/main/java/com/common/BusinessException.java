package com.common;

public class BusinessException extends RuntimeException{
    protected Integer code;
    protected String message;

    public BusinessException(ResultCode resultCode) {
        this.code = resultCode.getStatus();
        this.message = resultCode.getMsg();
    }
}
