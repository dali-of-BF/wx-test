package com.fang.wxcloudrun.domain.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author FPH
 * @since 2022年8月25日10:32:52
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CityInfoVO {
    @ApiModelProperty("详细地址")
    private String ref;

    @ApiModelProperty("编码")
    private String code;

    @ApiModelProperty("城市")
    private String city;
}
