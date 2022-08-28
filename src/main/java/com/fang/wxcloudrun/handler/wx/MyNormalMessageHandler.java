package com.fang.wxcloudrun.handler.wx;

import com.fang.wxcloudrun.domain.vo.WeatherVO;
import com.fang.wxcloudrun.service.AccessTokenService;
import com.fang.wxcloudrun.service.HttpService;
import com.fang.wxcloudrun.service.WeatherService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;
import org.weixin4j.model.message.OutputMessage;
import org.weixin4j.model.message.normal.*;
import org.weixin4j.model.message.output.TextOutputMessage;
import org.weixin4j.spi.INormalMessageHandler;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author FPH
 * @since 2022年8月23日14:50:41
 * 公众号普通消息处理
 */
@Component
@Slf4j
@RequiredArgsConstructor
public class MyNormalMessageHandler implements INormalMessageHandler {

    private final WeatherService weatherService;

    private final HttpService httpService;
    private final AccessTokenService accessTokenService;
    /**
     * 一般处理文字类型的消息
     * @param textInputMessage
     * @return
     */
    @Override
    public OutputMessage textTypeMsg(TextInputMessage textInputMessage) {
        String content = textInputMessage.getContent();
        if(textInputMessage.getMsgType().equals("text")&& StringUtils.isNotEmpty(content)&&content.contains("天气")){
            //判断是否是天气：城市或者是天气:城市
            List<String> list = Arrays.stream(content.split("天气")).collect(Collectors.toList());
            String handler = list.stream().findFirst().orElse(null);
            if(list.size()==1&& StringUtils.isNotEmpty(handler)){
                WeatherVO weather = weatherService.getWeather(handler);
                if(weather==null){
                    return new TextOutputMessage("查无此处，只能查询国内天气");
                }
                httpService.sendWeather(weather,accessTokenService.checkAccess(),textInputMessage.getFromUserName());
                return null;
            }
            if (list.size()==0){
                return new TextOutputMessage("你想查询哪里的天气呢？例如输入：厦门天气");
            }
        }
        return new TextOutputMessage("哈哈嘿");
    }

    @Override
    public OutputMessage imageTypeMsg(ImageInputMessage imageInputMessage) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public OutputMessage voiceTypeMsg(VoiceInputMessage voiceInputMessage) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public OutputMessage videoTypeMsg(VideoInputMessage videoInputMessage) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public OutputMessage shortvideoTypeMsg(ShortVideoInputMessage shortVideoInputMessage) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public OutputMessage locationTypeMsg(LocationInputMessage locationInputMessage) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public OutputMessage linkTypeMsg(LinkInputMessage linkInputMessage) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
