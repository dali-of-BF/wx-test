package com.fang.wxcloudrun.domain.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author FPH
 * @since 2022年8月28日15:12:27
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class WeatherCityInfoVO {
    @ApiModelProperty("城市")
    private String city;
    @ApiModelProperty("城市编码")
    private String citykey;
    @ApiModelProperty("福建")
    private String parent;
    @ApiModelProperty("更新时间")
    private String updateTime;
}
