package com.fang.wxcloudrun;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author FPH
 * @since 2022年8月22日15:18:36
 */
@SpringBootApplication
@MapperScan(basePackages = {"com.fang.wxcloudrun.mapper"})
public class WxCloudRunApplication {

  public static void main(String[] args) {
    SpringApplication.run(WxCloudRunApplication.class, args);
  }
}
