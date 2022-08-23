package com.fang.wxcloudrun.handler.wx;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.fang.wxcloudrun.domain.entity.WxUser;
import com.fang.wxcloudrun.service.WxUserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
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
@Slf4j
@RequiredArgsConstructor
public class MyEventMessageHandler implements IEventMessageHandler {

    private final WxUserService wxUserService;
    /**
     * 当公众号被订阅时
     * @param subscribeEventMessage
     * @return
     */
    @Override
    public OutputMessage subscribe(SubscribeEventMessage subscribeEventMessage) {
        log.info("接收方帐号（我自己）->"+subscribeEventMessage.getToUserName());
        log.info("从用户发送过来的openId->"+subscribeEventMessage.getFromUserName());
        //将关注者的OpenId存入数据库
        WxUser wxUser = new WxUser();
        wxUser.setOpenId(subscribeEventMessage.getFromUserName());
        wxUserService.save(wxUser);
        if(subscribeEventMessage.getFromUserName().equals("oaRsI6DITz7hSR5Tr6jTwZLvaQjo")){
            return new TextOutputMessage("热烈欢迎庄总关注猛男的公众号，欢迎欢迎热烈欢迎");
        }
        return new TextOutputMessage("感谢你的关注");
    }

    /**
     * 取消订阅，删除wxUser表的信息
     * @param unSubscribeEventMessage
     * @return
     */
    @Override
    public OutputMessage unSubscribe(UnSubscribeEventMessage unSubscribeEventMessage){
        //要取消关注的OpenId
        log.info("接收方帐号（收到的OpenID）->"+unSubscribeEventMessage.getFromUserName());
        WxUser wxUser = wxUserService.list(new LambdaQueryWrapper<WxUser>().eq(WxUser::getOpenId, unSubscribeEventMessage.getFromUserName())).stream().findFirst().orElse(null);
        if(wxUser!=null){
            wxUserService.removeById(wxUser.getId());
        }
        return new TextOutputMessage("Bye Bye");
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
