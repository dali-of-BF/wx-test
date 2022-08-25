package com.fang.wxcloudrun.controller;

import io.swagger.annotations.Api;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.weixin4j.spring.web.WeixinJieruController;

/**
 * @author FPH
 * @since 2022年8月22日22:46:10
 */
@Controller
@Api(tags = "接入微信(不要手动请求这个接口)")
@RequestMapping("load")
public class WxController extends WeixinJieruController {
}
