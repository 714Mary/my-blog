package com.example.blogbackend.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        // 对所有接口路径生效
        registry.addMapping("/**")
                // 允许所有前端域名跨域访问
                .allowedOrigins("*")
                // 允许 GET/POST/PUT/DELETE 这些请求方式
                .allowedMethods("GET", "POST", "PUT", "DELETE")
                // 允许所有请求头
                .allowedHeaders("*")
                // 预检请求的有效期（单位秒）
                .maxAge(3600);
    }
}
