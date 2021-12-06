package com.common;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

@RestControllerAdvice
@Slf4j
public class GlobalExceptionHeadler {

    /**
     * 处理运行时的异常
     */
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(Throwable.class)
    public ErrorResult handleThrowable(Throwable e, HttpServletRequest req) {
        ErrorResult result = ErrorResult.fail(ResultCode.SYSTEM_ERROR, e);
        log.error("URL:{}, 系统异常:", req.getRequestURL(), e);
        return result;
    }

    @ExceptionHandler(BusinessException.class)
    public ErrorResult handleBusinessException(BusinessException e, HttpServletRequest req) {
        ErrorResult result = ErrorResult.builder()
                .status(e.code)
                .execption(e.getClass().getName())
                .msg(e.message)
                .build();
        log.error("URL:{}, 业务异常:", req.getRequestURL(), e);
        return result;
    }
}
