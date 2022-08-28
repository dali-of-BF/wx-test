package com.fang.wxcloudrun.controller;

import com.alibaba.fastjson.JSONObject;
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
 * @auth fph
 * @since 2022年8月28日12:29:33
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("send")
@Api(tags = "推送消息")
public class SendMessageController {
    private final HttpService httpService;
    private final AccessTokenService accessTokenService;

    @GetMapping("sendCar")
    @ApiOperation("推送购车提示消息")
    public ResponseEntity<JSONObject> getUserInfo(String name, String car, String address, String openId){
        String accessToken = accessTokenService.checkAccess();
        return ResultUtil.success(httpService.sendMes(name,car,address,openId,accessToken));
    }
}
