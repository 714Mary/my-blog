package com.example.blogbackend.exception;
import com.example.blogbackend.common.Result;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

// 统一拦截所有控制器异常
@RestControllerAdvice
public class GlobalExceptionHandler {

    // 捕获所有未知异常
    @ExceptionHandler(Exception.class)
    public Result handleAllException(Exception e) {
        // 控制台打印异常堆栈，方便你排错
        e.printStackTrace();
        // 返回统一失败格式
        //return Result.error("系统繁忙，请稍后重试");
        return Result.fail("系统繁忙，请稍后重试");
    }
}