package com.fang.wxcloudrun.service;

import com.alibaba.fastjson.JSONObject;
import com.fang.wxcloudrun.domain.vo.CityInfoVO;
import com.fang.wxcloudrun.domain.vo.CityVO;
import lombok.RequiredArgsConstructor;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

/**
 * 天气业务类
 * @author FPH
 * @since 2022年8月25日10:10:39
 */
@Service
@RequiredArgsConstructor
public class WeatherService {

    private final HttpService httpService;

    private final AccessTokenService accessTokenService;
    /**
     * 通过城市获取天气信息
     * @param city
     * @return
     */
    public JSONObject getWeather(String city){
        accessTokenService.checkAccess();
        JSONObject result=new JSONObject();
        CityVO cityCode = httpService.getCityCode(city);
        List<CityInfoVO> list = cityCode.getList();
        if (CollectionUtils.isNotEmpty(list)){
            CityInfoVO cityInfoVO = list.stream().findFirst().orElse(null);
            result = httpService.getWeather(cityInfoVO.getCode());
        }
        return result;
    }
}
