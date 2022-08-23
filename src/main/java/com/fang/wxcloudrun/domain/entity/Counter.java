package com.fang.wxcloudrun.domain.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @author FPH
 * @since 2022年8月22日23:19:24
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("wx_test")
public class Counter  implements Serializable {

  private Integer id;

  private Integer count;

  private LocalDateTime createdAt;

  private LocalDateTime updatedAt;
}
