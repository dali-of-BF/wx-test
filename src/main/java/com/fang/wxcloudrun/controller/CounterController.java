package com.fang.wxcloudrun.controller;

import com.fang.wxcloudrun.config.ApiResponse;
import com.fang.wxcloudrun.domain.entity.Counter;
import com.fang.wxcloudrun.domain.dto.CounterRequest;
import com.fang.wxcloudrun.domain.entity.WxUser;
import com.fang.wxcloudrun.service.CounterService;
import com.fang.wxcloudrun.service.WxUserService;
import com.fang.wxcloudrun.utils.ResultUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

/**
 * counter控制器
 * @author FPH
 * @since 2022年8月22日23:20:44
 */
@RestController
@RequiredArgsConstructor
@Slf4j
@Api(tags = "微信云测试接口")
public class CounterController {

  private final CounterService counterService;

  private final WxUserService wxUserService;

  /**
   * 获取当前计数
   * @return API response json
   */
  @GetMapping(value = "/api/count")
  ApiResponse get() {
    log.info("/api/count get request");
    Optional<Counter> counter = counterService.getCounter(1);
    Integer count = 0;
    if (counter.isPresent()) {
      count = counter.get().getCount();
    }

    return ApiResponse.ok(count);
  }


  /**
   * 更新计数，自增或者清零
   * @param request {@link CounterRequest}
   * @return API response json
   */
  @PostMapping(value = "/api/count")
  ApiResponse create(@RequestBody CounterRequest request) {
    log.info("/api/count post request, action: {}", request.getAction());

    Optional<Counter> curCounter = counterService.getCounter(1);
    if (request.getAction().equals("inc")) {
      Integer count = 1;
      if (curCounter.isPresent()) {
        count += curCounter.get().getCount();
      }
      Counter counter = new Counter();
      counter.setId(1);
      counter.setCount(count);
      counterService.upsertCount(counter);
      return ApiResponse.ok(count);
    } else if (request.getAction().equals("clear")) {
      if (!curCounter.isPresent()) {
        return ApiResponse.ok(0);
      }
      counterService.clearCount(1);
      return ApiResponse.ok(0);
    } else {
      return ApiResponse.error("参数action错误");
    }
  }

  @PostMapping("test")
  @ApiOperation("插入测试接口")
  public ResponseEntity<String> test(){
    WxUser wxUser = new WxUser();
    wxUser.setOpenId("123123");
    return ResultUtil.success("OK");
  }
  @GetMapping("test1")
  @ApiOperation("查询测试接口")
  public ResponseEntity<List<WxUser>> test1(){
    List<WxUser> list = wxUserService.list();
    return ResultUtil.success(list);
  }


}
