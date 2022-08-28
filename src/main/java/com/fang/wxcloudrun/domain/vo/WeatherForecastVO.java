package com.fang.wxcloudrun.domain.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author FPH
 * @since 2022年8月28日14:49:02
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class WeatherForecastVO implements Serializable {

    @ApiModelProperty("最高温")
    private String high;

    @ApiModelProperty("最低温")
    private String low;

    @ApiModelProperty("日期")
    private String ymd;

    @ApiModelProperty("星期")
    private String week;

    @ApiModelProperty("太阳升起时间")
    private String sunrise;

    @ApiModelProperty("太阳降落时间")
    private String sunset;

    @ApiModelProperty("空气质量指数")
    private Integer aqi;

    @ApiModelProperty("风向")
    private String fx;

    @ApiModelProperty("风力")
    private String fl;

    @ApiModelProperty("天气类型")
    private String type;

    @ApiModelProperty("注意")
    private String notice;
}
