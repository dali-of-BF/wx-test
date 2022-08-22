package com.fang.wxcloudrun.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author FPH
 * @since 2022年8月22日23:20:02
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CounterRequest {

  // `action`：`string` 类型，枚举值
  // 等于 `"inc"` 时，表示计数加一
  // 等于 `"clear"` 时，表示计数重置（清零）
  private String action;

}
