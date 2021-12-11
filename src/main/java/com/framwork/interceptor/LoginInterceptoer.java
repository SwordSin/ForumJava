package com.framwork.interceptor;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Configuration
    public class LoginInterceptoer implements HandlerInterceptor {

    /**
     * 前置拦截器
     * @param request
     * @param response
     * @param handler
     * @return
     * @throws Exception
     */

//    @Autowired
//    StringRedisTemplate stringRedisTemplate;

    // 这段代码是为了防止爬虫类软件的代码, 确保响应的数据能够在一个进行登录请求成功后的会话中
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        System.out.println("验证session");
        return true;
//        System.out.println("验证session");
//        // 判断sessionid是否正确
//        System.out.println(request.getContextPath());
//        boolean sessionVer = false;
//        Cookie[] cookies = request.getCookies();
//        // 判断是否存在cookie
//        if (cookies == null) return sessionVer;
//
//        for (int i = 0;i < cookies.length;i++) {
//            if (cookies[i].getName().equals("JSESSIONID")) {
//                // cookie中的sessionid和sessionid中的相等
//                if (cookies[i].getValue().equals(request.getSession().getId())) {
//                    sessionVer = true;
//                    break;
//                }
//            }
//        }
//        return sessionVer;
    }
}
