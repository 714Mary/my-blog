package com.example.blogbackend.interceptor;

import com.example.blogbackend.common.Result;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 登录拦截器：校验是否登录
 */
public class LoginInterceptor implements HandlerInterceptor {

    // 前置拦截：接口执行之前先走这里
    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response,
                             Object handler) throws Exception {

        // 模拟：从session拿登录用户
        Object user = request.getSession().getAttribute("loginUser");
        // 如果没登录
        if (user == null) {
            // 设置响应编码、返回JSON
            response.setContentType("application/json;charset=UTF-8");
            Result result = Result.fail("请先登录");
            // 把Result转JSON返回给前端
            new ObjectMapper().writeValue(response.getWriter(), result);
            // 拦截：不放行
            return false;
        }
        // 已登录：放行，正常走接口
        return true;
    }
}