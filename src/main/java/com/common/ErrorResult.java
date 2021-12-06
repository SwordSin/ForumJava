package com.common;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ErrorResult {
    private Integer status; // 状态码
    private String msg; // 异常信息
    private String execption; // 异常名字

    public static ErrorResult fail(ResultCode resultCode, Throwable e, String msg) {
        ErrorResult result = ErrorResult.fail(resultCode, e);
        result.setMsg(msg);
        return result;
    }

    public static ErrorResult fail(ResultCode resultCode, Throwable e) {
        ErrorResult result = new ErrorResult();
        result.setStatus(resultCode.getStatus());
        result.setMsg(resultCode.getMsg());
        result.setExecption(e.getClass().getName());
        return result;
    }

}
