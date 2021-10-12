package com.example.demo.common;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author qzp
 * @Description: 全局异常处理
 * @date 2021/8/17 10:13
 */
@Slf4j
@RestControllerAdvice
public class RestExceptionHandle {

    /**
     * 默认异常处理
     * @param e 异常信息
     * @return resultData
     */
    @ExceptionHandler(Exception.class)
    public CommonResult<String> exception(Exception e) {
        log.error("捕获到异常信息：{}",e.getMessage());
        return CommonResult.fail(ReturnCode.RC500.getCode(),e.getMessage());
    }

}
