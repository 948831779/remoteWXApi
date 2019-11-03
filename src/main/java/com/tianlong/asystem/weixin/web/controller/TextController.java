package com.tianlong.asystem.weixin.web.controller;

import com.alibaba.fastjson.JSONObject;
import com.tianlong.asystem.weixin.web.entity.menu.*;
import com.tianlong.asystem.weixin.web.service.InvokingWeixinApi;
import com.tianlong.asystem.weixin.web.service.ReplyReleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

/**
 * 
 * 
   * 功能描述: 文本消息相关controller
 * @author tianlong@cdtiansh	eng.com
 * @date 2019年6月16日 下午10:36:52
 * @version 1.0
 */
@RestController
public class TextController {

	@Autowired
	private ReplyReleService replyReleService;
	@Autowired
	private InvokingWeixinApi invokingWeixinApi;
	
	@Autowired
	private WeiXinAuthorizationController weiXinAuthorizationController;
	/**
	 * 
	   * 功能描述: 回复文本消息
	 * @author tianlong@cdtiansheng.com
	 * @param 
	 * @return 
	 * 2019年6月16日
	 * @throws IOException 
	 */
	public void replyMessage(Map<String, String> data,HttpServletResponse response) throws IOException {
		
		if(data.get("Content").equals("学习")) {
			replyReleService.replyTextMessage(data,response);
			
		}else if(data.get("Content").equals("图片")){
			replyReleService.replyImageMessage(data,response);
		}else if(data.get("Content").equals("菜单")){

			createMenu();
		}
		 
	}

	private void createMenu() {
		ButtonMenu button = new ButtonMenu();
		button.getButton().add(new ClickButton("一级菜单","click01"));
		button.getButton().add(new ViewButton(weiXinAuthorizationController.assembleAuthorizationUrl(),"一级跳转"));
		SubButton subbuton = new SubButton("有子菜单");
		subbuton.getSub_button().add(new PhotoOrAlbumButton("照片","31"));
		subbuton.getSub_button().add(new ClickButton("点击","32"));
		subbuton.getSub_button().add(new ViewButton("https://www.163.com/","网易"));
		button.getButton().add(subbuton);
		Object json  = JSONObject.toJSON(button);
		System.out.println(json.toString());
		invokingWeixinApi.createMenu(json.toString());

	}
}
