package com.tianlong.asystem.weixin.web.service;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

/**
 * @program: asystem
 * @description: 回复相关接口
 * @author: tianl
 * @create: 2019-06-19 21:18
 **/
public interface ReplyReleService {

    /**
     * 回复文本消息
     * @param data
     * @param response
     */
    void replyTextMessage(Map<String, String> data, HttpServletResponse response)  throws IOException;

    /**
     * 回复图片消息
     * @param data
     * @param response
     */
    void replyImageMessage(Map<String, String> data, HttpServletResponse response) throws IOException ;

    /**
     * 回复语音消息
     * @param data
     * @param response
     */
    void replyVoiceMessage(Map<String, String> data, HttpServletResponse response) throws IOException ;

    /**
     * 回复视频消息
     * @param data
     * @param response
     */
    void replyVideoMessage(Map<String, String> data, HttpServletResponse response) throws IOException ;

    /**
     * 回复音乐消息
     * @param data
     * @param response
     */
    void replyMusicMessage(Map<String, String> data, HttpServletResponse response) throws IOException ;


    /**
     * 回复图文消息
     * @param data
     * @param response
     */
    void replynewsMessage(Map<String, String> data, HttpServletResponse response) throws IOException;



}
