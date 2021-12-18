package com.common;

import lombok.Data;

@Data
public class Result <T>{
    // 响应状态码
    private Integer status;
    // 响应内容描述
    private String statusText;
    // 返回的data数据
    private T data;

    // 成功, 但是没有返回值
    public static Result suc() {
        Result result = new Result();
        result.setResultCode(ResultCode.SUCCESS_NULL);
        return  result;
    }

    // 成功但有返回值
    public static <T> Result suc(T data) {
        Result result = new Result();
        result.setResultCode(ResultCode.SUCCESS);
        result.setData(data);
        return result;
    }

    // 失败, 指定code, msg
    public static Result fail(Integer status, String statusText) {
        Result result = new Result();
        result.setStatus(status);
        result.setStatusText(statusText);
        return result;
    }

    public static Result fail(ResultCode resultCode) {
        Result result = new Result();
        result.setResultCode(resultCode);
        return result;
    }

    private void setResultCode(ResultCode resultCode) {
        this.status = resultCode.getStatus();
        this.statusText = resultCode.getMsg();
    }

}
