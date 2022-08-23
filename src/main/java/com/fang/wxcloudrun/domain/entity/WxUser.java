package com.fang.wxcloudrun.domain.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.fang.wxcloudrun.domain.base.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author FPH
 * @since 2022年8月23日16:11:31
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("wx_user")
public class WxUser extends BaseEntity {

    private String openId;
}
