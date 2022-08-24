package com.fang.wxcloudrun;

import com.fang.wxcloudrun.service.HttpService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class test {

    @Autowired
    private HttpService httpService;

    @Test
    public void test(){
        httpService.sendMes();
    }
}
