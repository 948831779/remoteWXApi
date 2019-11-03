package com.tianlong.asystem.weixin.web.service.impl;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tianlong.asystem.weixin.web.entity.Image;
import com.tianlong.asystem.weixin.web.entity.ImageMessage;
import com.tianlong.asystem.weixin.web.entity.TextMessage;
import com.tianlong.asystem.weixin.web.service.InvokingWeixinApi;
import com.tianlong.asystem.weixin.web.service.ReplyReleService;
import com.tianlong.asystem.weixin.web.utils.XmlUtils;

/**
 * @program: asystem
 * @description: 回复消息实现类
 * @author: tianl
 * @create: 2019-06-19 21:23
 **/

@Service
public class ReplyReleServiceImpl  implements ReplyReleService {

    @Autowired
    private InvokingWeixinApi invokingWeixinApi;
    @Override
    public void replyTextMessage(Map<String, String> data, HttpServletResponse response) throws IOException {
        String token = invokingWeixinApi.createQrcode();
        System.out.println(token);
        TextMessage text = new TextMessage(data, "好好学习、天天向上");
        String xml = XmlUtils.beanToXml(text);
        PrintWriter pw = response.getWriter();
        pw.write(xml);
    }


    @Override
    public void replyImageMessage(Map<String, String> data, HttpServletResponse response)  throws IOException {
        ImageMessage text = new ImageMessage(data,  new Image("123"));
        String xml = XmlUtils.beanToXml(text);
        PrintWriter pw = response.getWriter();
        pw.write(xml);
    }

    @Override
    public void replyVoiceMessage(Map<String, String> data, HttpServletResponse response) throws IOException  {

    }

    @Override
    public void replyVideoMessage(Map<String, String> data, HttpServletResponse response) throws IOException  {

    }

    @Override
    public void replyMusicMessage(Map<String, String> data, HttpServletResponse response) throws IOException  {

    }

    @Override
    public void replynewsMessage(Map<String, String> data, HttpServletResponse response) throws IOException  {

    }
}
