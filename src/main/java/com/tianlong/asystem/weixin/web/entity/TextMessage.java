package com.tianlong.asystem.weixin.web.entity;

import java.util.Map;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.tianlong.asystem.weixin.web.constants.MessageEnum;

/**
 *  ToUserName 开发者微信号 
 *  FromUserName 发送方帐号（一个OpenID）
 *  CreateTime 消息创建时间 （整型） 
 *  MsgType 消息类型，文本为text 
 *  Content 文本消息内容 
 *  MsgId 消息id，64位整型
 * 
 * 功能描述: 文本消息实体类
 * 
 * @author tianlong@cdtiansheng.com
 * @date 2019年6月16日 下午10:39:33
 * @version 1.0
 */

@XStreamAlias(value = "xml")
public class TextMessage extends BaseMessage{

	/**
	 * 内容
	 */
	@XStreamAlias(value = "Content")
	private String content;

	public TextMessage(Map<String,String> map,String content) {
		super(map);
		this.setMsgType(MessageEnum.TEXT_MESSAGE.getValue());
		this.content = content;
	}
	
	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Override
	public String toString() {
		return "TextMessage [content=" + content + "]";
	}

 
}
