package com.fang.wxcloudrun.common.errors.translators;

import com.fang.wxcloudrun.common.errors.exceptions.BusinessException;
import com.fang.wxcloudrun.utils.ResultUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author FPH
 * @since 2022年8月22日23:45:05
 * 全局异常处理器
 */
@RestControllerAdvice
@Slf4j
public class ExceptionTranslator {

    /**
     * 业务异常捕获
     * @param e
     * @return
     */
    @ExceptionHandler(value = BusinessException.class)
    public ResponseEntity handleBusinessExceptionHandler(BusinessException e) {
        return ResultUtil.error(e.getMessage(), e.getErrData());
    }
    /**
     * 全局异常捕获
     * @param e
     * @return
     */
    @ExceptionHandler(Exception.class)
    public ResponseEntity handlerException(Exception e){
        log.error("出错了，请联系管理员:{}"+e);
        return ResultUtil.error("出错了，请联系管理员");
    }
}
