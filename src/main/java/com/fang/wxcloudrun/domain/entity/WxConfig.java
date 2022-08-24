package com.fang.wxcloudrun.domain.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.fang.wxcloudrun.domain.base.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author FPH
 * @since 2022年8月24日16:04:33
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@TableName("wx_config")
public class WxConfig extends BaseEntity {
    private String accessToken;
}
