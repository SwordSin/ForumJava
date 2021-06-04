package com.framwork.interceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;


@Component
public class LoginInterceptoer implements HandlerInterceptor {

    /**
     * 前置拦截器
     * @param request
     * @param response
     * @param handler
     * @return
     * @throws Exception
     */

    @Autowired
    StringRedisTemplate stringRedisTemplate;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        // 判断sessionid是否正确
        System.out.println(request.getContextPath());
        boolean sessionVer = false;
        for (int i = 0;i < request.getCookies().length;i++) {
            if (request.getCookies()[i].getName().equals("JSESSIONID")) {
                // cookie中的sessionid和sessionid中的相等
                if (request.getCookies()[i].getValue().equals(request.getSession().getId())) {
                    sessionVer = true;
                    break;
                }
            }
        }
        return sessionVer;
    }

    public static void main(String[] args) {
        System.out.println();
    }
}
