package com.fang.wxcloudrun.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.fang.wxcloudrun.domain.entity.WxUser;
import com.fang.wxcloudrun.mapper.WxUserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * @author FPH
 * @since 2022年8月23日16:24:26
 */
@Service
@RequiredArgsConstructor
public class WxUserService extends ServiceImpl<WxUserMapper, WxUser> {

}
