package com.fang.wxcloudrun.handler;

import org.springframework.stereotype.Component;
import org.weixin4j.model.message.OutputMessage;
import org.weixin4j.model.message.event.*;
import org.weixin4j.model.message.output.TextOutputMessage;
import org.weixin4j.spi.IEventMessageHandler;

/**
 * @author FPH
 * @since 2022年8月23日14:54:20
 * 公众号事件处理
 */
@Component
public class MyEventMessageHandler implements IEventMessageHandler {

    /**
     * 当公众号被订阅时
     * @param subscribeEventMessage
     * @return
     */
    @Override
    public OutputMessage subscribe(SubscribeEventMessage subscribeEventMessage) {
        return new TextOutputMessage("感谢你的关注");
    }

    @Override
    public OutputMessage unSubscribe(UnSubscribeEventMessage unSubscribeEventMessage) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public OutputMessage qrsceneSubscribe(QrsceneSubscribeEventMessage qrsceneSubscribeEventMessage) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public OutputMessage qrsceneScan(QrsceneScanEventMessage qrsceneScanEventMessage) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public OutputMessage location(LocationEventMessage locationEventMessage) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public OutputMessage click(ClickEventMessage clickEventMessage) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public OutputMessage view(ViewEventMessage viewEventMessage) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public OutputMessage scanCodePush(ScanCodePushEventMessage scanCodePushEventMessage) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public OutputMessage scanCodeWaitMsg(ScanCodeWaitMsgEventMessage scanCodeWaitMsgEventMessage) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public OutputMessage picSysPhoto(PicSysPhotoEventMessage picSysPhotoEventMessage) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public OutputMessage picPhotoOrAlbum(PicPhotoOrAlbumEventMessage picPhotoOrAlbumEventMessage) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public OutputMessage picWeixin(PicWeixinEventMessage picWeixinEventMessage) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public OutputMessage locationSelect(LocationSelectEventMessage locationSelectEventMessage) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
