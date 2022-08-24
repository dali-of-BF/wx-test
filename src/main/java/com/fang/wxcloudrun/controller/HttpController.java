package com.fang.wxcloudrun.controller;

import com.fang.wxcloudrun.service.HttpService;
import com.fang.wxcloudrun.utils.ResultUtil;
import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author FPH
 * @since 2022年8月24日14:33:00
 */
@RestController
@RequestMapping("http")
@Api(tags = "请求微信接口")
@RequiredArgsConstructor
public class HttpController {

    private final HttpService httpService;

    @GetMapping("getAccessToken")
    public ResponseEntity<String> getAccessToken(){
        return ResultUtil.success(httpService.getAccessToken());
    }
}
