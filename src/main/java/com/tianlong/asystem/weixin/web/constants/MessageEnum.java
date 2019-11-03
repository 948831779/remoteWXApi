package com.tianlong.asystem.weixin.web.constants;

/**
 * 
 * 
 * 功能描述: 消息类型枚举
 * 
 * @author tianlong@cdtiansheng.com
 * @date 2019年6月16日 下午10:20:32
 * @version 1.0
 */
public enum MessageEnum {

	/**
	 * 文本消息枚举
	 */
	TEXT_MESSAGE("text"),
	/**
	 * 视频消息枚举
	 */
	VIDEO_MESSAGE("video"),
	/**
	 * 图片消息枚举
	 */
	IMAGE_MESSAGE("image"),
	/**
	 * 视频消息枚举
	 */
	VOICE_MESSAGE("voice"),
	/**
	 * 小视频消息枚举
	 */
	SHORTVIDEO_MESSAGE("shortvideo"),

	/**
	 * 地理定位消息枚举
	 */
	LOCATION_MESSAGE("location"),

	/**
	 * 链接消息枚举
	 */
	LINK_MESSAGE("link");
	private String value;

	private MessageEnum(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

}
