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

    @GetMapping("checkRedisAccessToken")
    @ApiOperation("检查redis是否存在accessToken")
    public ResponseEntity<String> checkRedis(){
        accessTokenService.checkAccess();
        return ResultUtil.success("success");
    }

//    @GetMapping("getAccessToken")
//    @ApiOperation("获取/更新accessToken信息")
//    public ResponseEntity<String> getAccessToken(){
//        return ResultUtil.success(httpService.saveAccessToken());
//    }

//    @GetMapping("getCityCode")
//    @ApiOperation("通过城市名获取城市编码")
//    public ResponseEntity<CityVO> getCode(String city){
//        return ResultUtil.success(httpService.getCityCode(city));
//    }
//    @GetMapping("getWeather")
//    @ApiOperation("通过城市编码获取城市天气")
//    public ResponseEntity<JSONObject> getWeather(String code){
//        return ResultUtil.success(httpService.getWeather(code));
//    }

    @GetMapping("getUserInfo")
    @ApiOperation("通过openId获取用户信息")
    public ResponseEntity<JSONObject> getUserInfo(String openId){
        accessTokenService.checkAccess();
        return ResultUtil.success(httpService.getUserInfo(openId));
    }

    @GetMapping
    @ApiOperation("发送消息")
    public ResponseEntity<JSONObject> getUserInfo(String name,String car,String address,String openId){
        accessTokenService.checkAccess();
        String accessToken = accessTokenService.getAccessToken();
        httpService.sendMes(name,car,address,openId,accessToken);
        return ResultUtil.success("success");

    }
}
