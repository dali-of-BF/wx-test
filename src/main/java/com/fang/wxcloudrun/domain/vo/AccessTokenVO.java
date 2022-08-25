package com.fang.wxcloudrun.domain.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author FPH
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AccessTokenVO {
    private String access_token;
    private Long expires_in;
}
