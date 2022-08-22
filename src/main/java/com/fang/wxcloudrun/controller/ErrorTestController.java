package com.fang.wxcloudrun.controller;

import com.fang.wxcloudrun.common.errors.exceptions.BusinessException;
import com.fang.wxcloudrun.utils.ResultUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author FPh
 * @since 2022年8月23日00:10:04
 */
@RestController
public class ErrorTestController {

    @GetMapping("error")
    public ResponseEntity<String> testError(){
        new BusinessException("这是一条测试错误");
        return ResultUtils.error("测试失败");
    }
}
