package com.fang.wxcloudrun.domain.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author FPH
 * @since 2022年8月28日14:44:23
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class WeatherVO {
    @ApiModelProperty("日期")
    private String time;

    private WeatherCityInfoVO cityInfo;
    private WeatherDetailVO data;
}
