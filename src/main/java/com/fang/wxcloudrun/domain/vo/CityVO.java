package com.fang.wxcloudrun.domain.vo;

import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CityVO {
    @ApiModelProperty("输入的城市")
    private String city;

    @ApiModelProperty("模糊匹配城市列表")
    private List<CityInfoVO> list;
}
