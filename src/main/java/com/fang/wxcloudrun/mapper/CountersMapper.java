package com.fang.wxcloudrun.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.fang.wxcloudrun.domain.entity.Counter;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author FPH
 * @since 2022年8月22日23:19:41
 */
@Mapper
public interface CountersMapper  extends BaseMapper<Counter> {

  Counter getCounter(@Param("id") Integer id);

  void upsertCount(Counter counter);

  void clearCount(@Param("id") Integer id);
}
