package com.tianlong.asystem.weixin.web.entity;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.tianlong.asystem.weixin.web.constants.MessageEnum;

import java.util.Map;

/**
 * ToUserName	是	接收方帐号（收到的OpenID）
 * FromUserName	是	开发者微信号
 * CreateTime	是	消息创建时间 （整型）
 * MsgType	是	消息类型，图片为image
 * MediaId	是	通过素材管理中的接口上传多媒体文件，得到的id。
 *
 * @program: asystem
 * @description: 图片消息实体类
 * @author: tianl
 * @create: 2019-06-19 21:02
 **/
@XStreamAlias(value = "xml")
public class ImageMessage  extends BaseMessage{

    @XStreamAlias(value = "Image")
    private Image image;

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public ImageMessage(Map<String, String> map, Image image) {
        super(map);
        this.setMsgType(MessageEnum.IMAGE_MESSAGE.getValue());
        this.image = image;
    }
}
