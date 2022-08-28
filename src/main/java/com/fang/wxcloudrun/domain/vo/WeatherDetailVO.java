package com.fang.wxcloudrun.domain.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * @author FPH
 * @since 2022年8月28日14:46:2
 *
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class WeatherDetailVO {
    @ApiModelProperty("湿度")
    private String shidu;
    @ApiModelProperty("PM25")
    private Integer pm25;
    @ApiModelProperty("PM10")
    private Integer pm10;
    @ApiModelProperty("质量")
    private String quality;
    @ApiModelProperty("温度")
    private String wendu;
    @ApiModelProperty("感冒")
    private String ganmao;

    private List<WeatherForecastVO> forecast;
}
