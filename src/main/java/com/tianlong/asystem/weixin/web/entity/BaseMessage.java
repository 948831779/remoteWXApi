package com.tianlong.asystem.weixin.web.entity;

import java.util.Date;
import java.util.Map;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * 
 * 
   * 功能描述: 消息基础类
 * @author tianlong@cdtiansheng.com
 * @date 2019年6月16日 下午10:52:30
 * @version 1.0
 */
public class BaseMessage {
	/**
	 * 发送时间
	 */
	@XStreamAlias(value = "CreateTime")
	private String createTime;

	/**
	 * 开发者微信号
	 */
	@XStreamAlias(value = "ToUserName")
	private String toUserName;

	/**
	 * 发送方微信ID openid
	 */
	@XStreamAlias(value = "FromUserName")
	private String fromUserName;

	/**
	 * 消息id，64位整型
	 */
	@XStreamAlias(value = "MsgId")
	private String msgId;
	
	/**
	 * 消息类型
	 */
	@XStreamAlias(value = "MsgType")
	private String msgType;

	public BaseMessage(Map<String,String> map) {
		if(null != map){
			this.createTime = System.currentTimeMillis() /1000 +"";
			this.fromUserName = map.get("ToUserName");
			this.toUserName =  map.get("FromUserName");
		}

	}
	
	
	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public String getToUserName() {
		return toUserName;
	}

	public void setToUserName(String toUserName) {
		this.toUserName = toUserName;
	}

	public String getFromUserName() {
		return fromUserName;
	}

	public void setFromUserName(String fromUserName) {
		this.fromUserName = fromUserName;
	}

	public String getMsgId() {
		return msgId;
	}

	public void setMsgId(String msgId) {
		this.msgId = msgId;
	}

	public String getMsgType() {
		return msgType;
	}

	public void setMsgType(String msgType) {
		this.msgType = msgType;
	}


	@Override
	public String toString() {
		return "BaseMessage [createTime=" + createTime + ", toUserName=" + toUserName + ", fromUserName=" + fromUserName
				+ ", msgId=" + msgId + ", msgType=" + msgType + "]";
	}
	
	
	
}
