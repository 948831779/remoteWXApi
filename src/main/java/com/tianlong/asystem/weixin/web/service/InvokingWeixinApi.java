package com.tianlong.asystem.weixin.web.service;

import java.util.Map;

/**
 * @program: asystem
 * @description: 调用微信相关api
 * @author: tianl
 * @create: 2019-06-19 21:50
 **/
public interface InvokingWeixinApi {
    /**
     * 获取access_token
     * @return
     */
   String getAccessToken();
   
   /**
    * 
            * 功能描述: 创建二维码
    * @author tianlong@cdtiansheng.com
    * @param 
    * @return 
    * 2019年6月21日
    */
   String createQrcode();
   
   /**
    * 
           * 功能描述: 获取二维码ticket
    * @author tianlong@cdtiansheng.com
    * @param 
    * @return 
    * 2019年6月21日
    */

   String createQrcodeTicket();

   /**
    * 创建菜单
    * @param jsonStrForMenus  菜单对象的str
    */
   Map<String,Object> createMenu(String jsonStrForMenus);

   /**
    * 通过code换取网页授权access_token
    * @param code
    * @return
    */
   String getAuthorizationToken(String code);

/***
 * 拉取用户信息(需scope为 snsapi_userinfo)
 */
    String getUserInfo(String openId);

    /***
     * 用户同意授权，获取code
     * @param url
     */
    String obtainauthorizecode(String url,String scope);
}
