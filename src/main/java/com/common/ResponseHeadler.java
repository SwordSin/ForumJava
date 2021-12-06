package com.common;

import com.alibaba.druid.support.json.JSONUtils;
import com.alibaba.fastjson.JSONObject;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

@ControllerAdvice("com") // 根目录入口, 用于扩展controller功能
// 1. 全局response统一处理
// 2. 全局异常的统一处理
public class ResponseHeadler implements ResponseBodyAdvice<Object> {

    // 是否支持, responeseAdvice功能
    @Override
    public boolean supports(MethodParameter methodParameter, Class<? extends HttpMessageConverter<?>> aClass) {
        return true;
    }

    // 具体的处理response方法
    @Override
    public Object beforeBodyWrite(Object o, MethodParameter methodParameter, MediaType mediaType, Class<? extends HttpMessageConverter<?>> aClass, ServerHttpRequest serverHttpRequest, ServerHttpResponse serverHttpResponse) {
        if(o instanceof  String) {
            return JSONObject.toJSONString(Result.suc(o));
        } else if(o instanceof ErrorResult) {
            ErrorResult result = (ErrorResult) o;
            return Result.fail(result.getStatus(), result.getMsg());
        }
        return Result.suc(o);
    }
}
