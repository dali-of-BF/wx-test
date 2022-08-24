package com.fang.wxcloudrun.service;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.fang.wxcloudrun.domain.vo.AccessTokenVO;
import com.fang.wxcloudrun.domain.entity.WxConfig;
import com.fang.wxcloudrun.domain.vo.WxUserInfo;
import com.fang.wxcloudrun.mapper.WxConfigMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.Instant;

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
    public void getUserInfo(){
        WxConfig wxConfig = wxConfigMapper.selectList(new LambdaQueryWrapper<WxConfig>().orderByDesc(WxConfig::getCreatedDate)).stream().findFirst().orElse(null);
        String openId="oCahj6LRXev7t8C9voxt4AuZqzAg";
        if(wxConfig!=null){
            String url="https://api.weixin.qq.com/cgi-bin/user/info?access_token="+wxConfig.getAccessToken()+"&openid="+openId;
            JSONObject forObject = restTemplate.getForObject(url, JSONObject.class);
            log.info(forObject.toJSONString());
        }
    }

    public void sendMes(){
        WxConfig wxConfig = wxConfigMapper.selectList(new LambdaQueryWrapper<WxConfig>().orderByDesc(WxConfig::getCreatedDate)).stream().findFirst().orElse(null);
        String openId="oCahj6I9P0Uw2xA2V0PrYjlPJoQY";
        if(wxConfig!=null){
            String url="https://api.weixin.qq.com/cgi-bin/message/template/send?access_token="+wxConfig.getAccessToken();
            JSONObject postDate = new JSONObject();
            postDate.put("touser",openId);
            postDate.put("template_id","bA29yBX8iQd-DX0y0e5DyGQ_EnNZEnH56iQ3pxf0XNI");
            postDate.put("topcolor","#FF0000");
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("User","方"+".DATA");
            jsonObject.put("Date", Instant.now()+".DATA");
            postDate.put("data", jsonObject);
            log.info(postDate.toJSONString());
            JSONObject body = restTemplate.postForEntity(url, postDate, JSONObject.class).getBody();
            log.info(body.toJSONString());
        }
    }
}
