package com.tianlong.asystem.weixin.web.controller;

import com.tianlong.asystem.weixin.web.service.InvokingWeixinApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @program: asystem
 * @description: 微信授权controller
 * @author: tianl
 * @create: 2019-06-26 21:58
 **/

@Controller
@RequestMapping(value = "weixin")
public class WeiXinAuthorizationController {

    @Autowired
    private InvokingWeixinApi invokingWeixinApi;

    /**
     * 用户同意授权，获取code   不行、因为微信服务器会坚持是不是微信浏览器  、、只能通过html跳转
     * @param code
     * @return
     * @throws UnsupportedEncodingException 
     */

    @RequestMapping(value =  "assembleAuthorizationUrl")
    public String assembleAuthorizationUrl(){
         String url = "http://tianlong0810.top/asystem-weixin-service/weixin/weixinCallback.htm";
         try {
			url = URLEncoder.encode(url,"utf-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
          
        return  invokingWeixinApi.obtainauthorizecode(url,"snsapi_userinfo");
     }



    @RequestMapping(value =  "weixinCallback")
    public String callback(String code,HttpServletResponse response) throws IOException{

        //1、根据code获取access_token
       String token =  invokingWeixinApi.getAuthorizationToken(code);
        System.out.println("进入weixinCallback");
        // 2、获取openid
       PrintWriter out =  response.getWriter();
       out.write("SUCCESS");
         
    	 return "redirect:/common/skipQrCode.htm";
    	 
    }
}
