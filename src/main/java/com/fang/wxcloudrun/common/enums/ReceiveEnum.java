package com.fang.wxcloudrun.common.enums;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * @author FPH
 * @since 2022年8月28日14:24:39
 */
@AllArgsConstructor
@Getter
public enum ReceiveEnum {
    ONE("天气","xx"),
    CAR("买车","");

    private String value;
    private String bean;


}
