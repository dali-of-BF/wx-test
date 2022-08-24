package com.fang.wxcloudrun.service;

import com.fang.wxcloudrun.domain.vo.AccessTokenVO;
import com.fang.wxcloudrun.domain.entity.WxConfig;
import com.fang.wxcloudrun.mapper.WxConfigMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * @author FPH
 * @since 2022年8月24日14:41:24
 */
@Service
@RequiredArgsConstructor
@Slf4j
public class HttpService {
    private final RestTemplate restTemplate;
    private final WxConfigMapper wxConfigMapper;

    @Value("${weixin4j.oauth.appid}")
    private String appid;

    @Value("${weixin4j.oauth.secret}")
    private String secret;

    public String getAccessToken(){
        log.info("appid-->"+appid);
        log.info("secret-->"+secret);
        String url="https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid="+appid+"&secret="+secret;
        AccessTokenVO forObject = restTemplate.getForObject(url, AccessTokenVO.class);
        log.info("AccessToken-->"+forObject.toString());
        //存入数据库
        wxConfigMapper.delete(null);
        wxConfigMapper.insert(WxConfig.builder().accessToken(forObject.getAccess_token()).build());
        return forObject.getAccess_token();
    }
}
