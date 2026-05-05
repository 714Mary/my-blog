package com.example.blogbackend.config;

import com.example.blogbackend.interceptor.LoginInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    // 注册拦截器
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginInterceptor())
                // 拦截所有请求
                .addPathPatterns("/**")
                // 放行登录、注册接口（不需要拦截）
                .excludePathPatterns("/user/login","/user/register");
    }
}
