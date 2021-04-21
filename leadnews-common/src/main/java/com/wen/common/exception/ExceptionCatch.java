package com.wen.common.exception;

import com.wen.model.dtos.ResponseResult;
import com.wen.model.enums.AppHttpCodeEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.handler.annotation.support.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @Description:  目的是给用户提供友好的提示信息
 * @Version: V1.0
 */
@Slf4j
@Configuration
@RestControllerAdvice   // Springmvc 异常处理拦截注解
public class ExceptionCatch {


    /**
     * 解决项目中所有的异常拦截
     *
     * @return
     */
    @ExceptionHandler(Exception.class)  // exception 所有子类
    public ResponseResult exception(Exception ex) {
        // 记录日志
        log.error("ExceptionCatch ex:{}", ex);

        return ResponseResult.errorResult(AppHttpCodeEnum.SERVER_ERROR, "网络走丢了呢！请稍后重试哦");
    }


    /**
     * 参数校验
     * @param ex
     * @return
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseResult handleValidationException(MethodArgumentNotValidException ex) {
        log.error("MethodArgumentNotValidException ex:{}", ex);
        ex.printStackTrace();
        return ResponseResult.errorResult(AppHttpCodeEnum.PARAM_INVALID, ex.getBindingResult().getFieldError().getDefaultMessage());
    }
}