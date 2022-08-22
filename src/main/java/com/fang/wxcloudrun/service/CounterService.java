package com.fang.wxcloudrun.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.fang.wxcloudrun.mapper.CountersMapper;
import com.fang.wxcloudrun.model.Counter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * @author FPH
 * @since 2022年8月22日23:19:05
 */
@Service
public class CounterService extends ServiceImpl<CountersMapper,Counter> {

  private final CountersMapper countersMapper;

  public CounterService(@Autowired CountersMapper countersMapper) {
    this.countersMapper = countersMapper;
  }

  public Optional<Counter> getCounter(Integer id) {
    return Optional.ofNullable(countersMapper.getCounter(id));
  }

  public void upsertCount(Counter counter) {
    countersMapper.upsertCount(counter);
  }

  public void clearCount(Integer id) {
    countersMapper.clearCount(id);
  }
}
