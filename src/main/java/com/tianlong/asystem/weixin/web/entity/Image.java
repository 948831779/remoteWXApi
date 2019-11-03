package com.tianlong.asystem.weixin.web.entity;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * @program: asystem
 * @description: 图片
 * @author: tianl
 * @create: 2019-06-19 21:03
 **/
@XStreamAlias(value = "Image")
public class Image {

    /**
     * 	通过素材管理中的接口上传多媒体文件，得到的id。
     */
    @XStreamAlias(value = "mediaId")
    private String mediaId;
    public Image() {
    }
    public Image(String mediaId) {
        this.mediaId = mediaId;
    }

    public String getMediaId() {
        return mediaId;
    }

    public void setMediaId(String mediaId) {
        this.mediaId = mediaId;
    }
}
