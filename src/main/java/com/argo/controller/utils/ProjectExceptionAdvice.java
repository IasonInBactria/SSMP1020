package com.argo.controller.utils;


import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author YangY
 * springmvc的异常处理器
 */
@RestControllerAdvice
public class ProjectExceptionAdvice {
    /**
     * @param exception
     * @return
     *
     * 拦截所有异常
     */
    @ExceptionHandler
    public Result doException(Exception exception){
        exception.printStackTrace();
        return new Result("服务器故障，请稍后再试！");
    }
}
