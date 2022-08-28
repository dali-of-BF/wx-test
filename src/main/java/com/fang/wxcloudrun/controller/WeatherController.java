package com.fang.wxcloudrun.controller;

import com.fang.wxcloudrun.domain.vo.WeatherVO;
import com.fang.wxcloudrun.service.WeatherService;
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
 * @since 2022年8月25日11:03:54
 */
@RestController
@RequestMapping("weather")
@RequiredArgsConstructor
@Api(tags = "获取天气")
public class WeatherController {
    private final WeatherService weatherService;

    @GetMapping("getWeather")
    @ApiOperation("根据城市获取天气")
    public ResponseEntity<WeatherVO> getWeather(String city){
        return ResultUtil.success(weatherService.getWeather(city));
    }
}
