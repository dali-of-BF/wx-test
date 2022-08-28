package com.fang.wxcloudrun;


import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author FPH
 * @since 2022年8月22日15:18:36
 */
@SpringBootApplication
@Slf4j
@MapperScan(basePackages = {"com.fang.wxcloudrun.mapper"})
public class WxCloudRunApplication {

  public static void main(String[] args) {
    SpringApplication.run(WxCloudRunApplication.class, args);
    log.info("http://localhost:8084/wx/doc.html");
  }
}
