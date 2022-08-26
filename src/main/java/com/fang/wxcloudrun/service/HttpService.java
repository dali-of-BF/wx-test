package com.fang.wxcloudrun.service;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.fang.wxcloudrun.domain.entity.WxConfig;
import com.fang.wxcloudrun.domain.vo.AccessTokenVO;
import com.fang.wxcloudrun.domain.vo.CityInfoVO;
import com.fang.wxcloudrun.domain.vo.CityVO;
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

    /**
     * 将accessToken保存进数据库
     * @return
     */
    public String saveAccessToken(){
        //存入数据库
        AccessTokenVO accessToken = getAccessToken();
        wxConfigMapper.delete(null);
        wxConfigMapper.insert(WxConfig.builder().accessToken(accessToken.getAccess_token()).build());
        return accessToken.getAccess_token();
    }

    /**
     * 查询accessToken
     * @return
     */
    public AccessTokenVO getAccessToken(){
        String url="https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid="+appid+"&secret="+secret;
        return restTemplate.getForObject(url, AccessTokenVO.class);
    }


    /**
     * 通过openId获取用户信息
     * @param openId
     */
    public JSONObject getUserInfo(String openId){
        WxConfig wxConfig = wxConfigMapper.selectList(new LambdaQueryWrapper<WxConfig>().orderByDesc(WxConfig::getCreatedDate)).stream().findFirst().orElse(null);
        String url="https://api.weixin.qq.com/cgi-bin/user/info?access_token="+wxConfig.getAccessToken()+"&openid="+openId;
        JSONObject forObject = restTemplate.getForObject(url, JSONObject.class);
        return forObject;
    }

    public JSONObject sendMes(String name,String car,String address,String openId,String accessToken){
        String url="https://api.weixin.qq.com/cgi-bin/message/template/send?access_token="+accessToken;
        JSONObject postDate = new JSONObject();
        postDate.put("touser",openId);
        postDate.put("template_id","LeFaXVruTFz2qy0aN2mrg9YRnje6Edp7804ZRmrK3-U");
        postDate.put("color","#FF0000");
        JSONObject jsonObject = new JSONObject();
        JSONObject value1 = new JSONObject();
        value1.put("value","购车通知");
        value1.put("color","#173177");
        jsonObject.put("title",value1);
//            ---
        JSONObject value2 = new JSONObject();
        value2.put("value",name);
        value2.put("color","#173177");
        jsonObject.put("name",value2);
//            ---
        JSONObject value3 = new JSONObject();
        value3.put("value",address);
        value3.put("color","#173177");
        jsonObject.put("address", value3);
//            --
        JSONObject value4 = new JSONObject();
        value4.put("value",car);
        value4.put("color","#173177");
        jsonObject.put("car", value4);

        postDate.put("data", jsonObject);
        log.info(postDate.toJSONString());
        JSONObject body = restTemplate.postForEntity(url, postDate, JSONObject.class).getBody();
        log.info(body.toJSONString());
        return body;
    }

    /**
     * 通过城市获取城市编码
     * @param city
     * @return
     */
    public CityVO getCityCode(String city){
        String url="http://www.iot2ai.top/cgi-bin/intel/weather.txt?city="+city;
        log.info("城市编码地址-->"+url);
        CityVO forObject = restTemplate.getForObject(url, CityVO.class);
        return forObject;
    }

    /**
     * 通过城市编码获取天气
     * @param code
     * @return
     */
    public JSONObject getWeather(String code){
        String url="http://t.weather.sojson.com/api/weather/city/"+code;
        log.info("天气地址-->"+url);
        JSONObject forObject = restTemplate.getForObject(url, JSONObject.class);
        return forObject;
    }
}
