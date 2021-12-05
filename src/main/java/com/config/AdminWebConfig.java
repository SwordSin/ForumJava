package com.config;

import com.framwork.interceptor.LoginInterceptoer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@Configuration
public class AdminWebConfig implements WebMvcConfigurer {

    @Autowired
    private LoginInterceptoer loginInterceptoer;
//
//    // 添加拦截器的配置
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
//        registry.addInterceptor(loginInterceptoer)
//                // 需要被拦截的路由
//                .addPathPatterns("/**")
//                // 不可以被拦截的路由
//                .excludePathPatterns("/userInfo/login")
//                .excludePathPatterns("/userInfo/registerInfo")
//                // 临时允许测试用地址
//                .excludePathPatterns("/board/getBoardInfo")
//                .excludePathPatterns("/board/savePostsInfo")
//                .excludePathPatterns("/board/getPagePostsInfo")
//                .excludePathPatterns("/board/getPostsInfoOne")
//                .excludePathPatterns("/useRedis/saveRedis")
//                .excludePathPatterns("/swagger-resources/**", "/webjars/**", "/v2/**", "/swagger-ui.html/**")
//                .excludePathPatterns("/dealBigData/getBigData")
//                .excludePathPatterns("/dealBigData/insetBigData2");
    }
}
