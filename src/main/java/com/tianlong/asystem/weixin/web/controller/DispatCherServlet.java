package com.tianlong.asystem.weixin.web.controller;

import com.tianlong.asystem.weixin.web.constants.MessageEnum;
import com.tianlong.asystem.weixin.web.entity.TextMessage;
import com.tianlong.asystem.weixin.web.utils.CheckUtil;
import com.tianlong.asystem.weixin.web.utils.XmlUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

/**
 *
 * @author tianl
 * @date 2016/10/31
 */
@RestController
@RequestMapping(value = "servlet")
public class DispatCherServlet {
	private static final Logger logger = LoggerFactory.getLogger(DispatCherServlet.class);

	@Autowired
	private TextController textController;
  	/**
	 * 
	 * 功能描述: 验签
	 * 
	 * @author tianlong@cdtiansheng.com
	 * @param
	 * @return 2019年6月16日
	 */
	@RequestMapping(value = "/dispatCherServlet", method = { RequestMethod.GET })
	public String getDispatCherServlet(String signature, String timestamp, String nonce, String echostr) {
		boolean checkSignature = CheckUtil.checkSignature(signature, timestamp, nonce);
		if (!checkSignature) {
			logger.error("验证不成功");
			return null;
		}
		logger.debug("echostr =" + echostr);
		return echostr;
	}

	/**
	 * 
	 * 功能描述: 获取消息和事件推送
	 * 
	 * @author tianlong@cdtiansheng.com
	 * @param
	 * @return 2019年6月16日
	 */
	@RequestMapping(value = "/dispatCherServlet", method = { RequestMethod.POST })
	public void getMessage(HttpServletRequest request, HttpServletResponse response) {
		Map<String, String> data = null;
 		try {
 			data = XmlUtils.parseXml(request);
 			System.out.println(data);
			String MsgType = data.get("MsgType");
 			 if(MessageEnum.TEXT_MESSAGE.getValue().equalsIgnoreCase(MsgType)) {
				 logger.debug("文本消息=" + data.toString());
				 textController.replyMessage(data,response);
			 }else if(MessageEnum.VIDEO_MESSAGE.getValue().equalsIgnoreCase(MsgType)){
				 logger.debug("视频消息=" + data.toString());
			 }else if(MessageEnum.IMAGE_MESSAGE.getValue().equalsIgnoreCase(MsgType)){
				 logger.debug("图片消息=" + data.toString());
			 }else if(MessageEnum.VOICE_MESSAGE.getValue().equalsIgnoreCase(MsgType)){
				 logger.debug("声音消息=" + data.toString());
			 }else if(MessageEnum.SHORTVIDEO_MESSAGE.getValue().equalsIgnoreCase(MsgType)){
				 logger.debug("小视频消息=" + data.toString());
			 }else if(MessageEnum.LOCATION_MESSAGE.getValue().equalsIgnoreCase(MsgType)){
				 logger.debug("地理位置消息=" + data.toString());
			 }else if(MessageEnum.LINK_MESSAGE.getValue().equalsIgnoreCase(MsgType)){
				 logger.debug("链接消息=" + data.toString());
			 }
			
		} catch (Exception e) {
			error(data,response);
			 e.printStackTrace();
		}

	}
	
	
	public void error(Map<String, String> data,HttpServletResponse response) {
		TextMessage text = new TextMessage(data, "异常");
			String xml = XmlUtils.beanToXml(text);
			 PrintWriter pw;
			try {
				pw = response.getWriter();
				 pw.write(xml);
			} catch (IOException e) {
 				e.printStackTrace();
			}
		
	}
}
