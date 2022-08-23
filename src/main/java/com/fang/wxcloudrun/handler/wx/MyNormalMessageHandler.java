package com.fang.wxcloudrun.handler.wx;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.weixin4j.model.message.OutputMessage;
import org.weixin4j.model.message.normal.*;
import org.weixin4j.model.message.output.TextOutputMessage;
import org.weixin4j.spi.INormalMessageHandler;

/**
 * @author FPH
 * @since 2022年8月23日14:50:41
 * 公众号普通消息处理
 */
@Component
@Slf4j
public class MyNormalMessageHandler implements INormalMessageHandler {
    /**
     * 一般处理文字类型的消息
     * @param textInputMessage
     * @return
     */
    @Override
    public OutputMessage textTypeMsg(TextInputMessage textInputMessage) {
        log.info("textInputMessage-->"+textInputMessage.getFromUserName());
        return new TextOutputMessage("已经接收到猛男的消息");
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
