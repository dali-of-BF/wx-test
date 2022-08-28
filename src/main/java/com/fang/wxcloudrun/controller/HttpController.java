package com.fang.wxcloudrun.controller;

import com.alibaba.fastjson.JSONObject;
import com.fang.wxcloudrun.domain.vo.CityVO;
import com.fang.wxcloudrun.service.AccessTokenService;
import com.fang.wxcloudrun.service.HttpService;
import com.fang.wxcloudrun.utils.ResultUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
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

    private final AccessTokenService accessTokenService;


    @GetMapping("getUserInfo")
    @ApiOperation("通过openId获取用户信息")
    public ResponseEntity<JSONObject> getUserInfo(String openId){
        String accessToken = accessTokenService.checkAccess();
        return ResultUtil.success(httpService.getUserInfo(openId,accessToken));
    }
}
