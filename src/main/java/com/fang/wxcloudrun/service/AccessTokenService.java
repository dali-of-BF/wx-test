package com.fang.wxcloudrun.service;

import com.fang.wxcloudrun.domain.vo.AccessTokenVO;
import com.fang.wxcloudrun.utils.RedisUtil;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

/**
 * @author FPH
 * @since 2022年8月25日14:46:58
 */
@Service
@RequiredArgsConstructor
public class AccessTokenService {

    private final HttpService httpService;

    private final RedisUtil redisUtil;

    /**
     * 检查redis中accessToken是否过期
     */
    public void checkAccess(){
        String accessToken = getAccessToken();
        if(StringUtils.isEmpty(accessToken)){
            AccessTokenVO accessTokenVO = httpService.getAccessToken();
            saveAccessTokenForRedis(accessTokenVO);
        }
    }

    public String getAccessToken(){
        return redisUtil.get("access:Token");
    }

    /**
     * 保存accessToken到redis中
     * @param accessTokenVO
     */
    public void saveAccessTokenForRedis(AccessTokenVO accessTokenVO){
        redisUtil.set("access:Token",accessTokenVO.getAccess_token(),accessTokenVO.getExpires_in());
    }
}
