package com.tianlong.asystem.weixin.web.service.impl;


import com.alibaba.fastjson.JSONObject;
import com.tianlong.asystem.weixin.web.constants.WeiXinApiLinks;
import com.tianlong.asystem.weixin.web.constants.WeiXinKeyInformation;
import com.tianlong.asystem.weixin.web.service.InvokingWeixinApi;
import com.tianlong.asystem.weixin.web.utils.UrlRele;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: asystem
 * @description: 调用微信api接口实现
 * @author: tianl
 * @create: 2019-06-19 21:51
 **/

@Service
public class InvokingWeixinApiImpl implements InvokingWeixinApi {

	private static AccsessToken accsessToken;
//    @Autowired
//   private RedisUtil redisUtil;

    @Override
    public String getAccessToken() {
    	if(null != accsessToken && accsessToken.beExpire()) {
    		return accsessToken.getAccessToken();
    	}
//         if (redisUtil.checkCacheObject(WeiXinKeyInformation.WEIXIN_KEY)) {
//        	 String access_token = (String) redisUtil.getHashMapValue(WeiXinKeyInformation.WEIXIN_KEY,WeiXinKeyInformation.ACCESS_TOKEN);
//         }
        return getToken();
    }



/**
 *  {"access_token":"22_oGwTUr1ZGTexLAcpMUG0bM_6ZMO4NJB9sDXY9AnPTb2mYeX7sE_D3NyKDYj5i7OmyQauy7GSb9vrwQaxsYEbEyEQI2Bp5HhGx2MubKp2m0B1f6zV1TdgxvKy4SlKPJVmaQmIvVi7qF7wXwKaPFXbACAUKC",
 *  "expires_in":7200}

 * 功能描述: 
 * @author tianlong@cdtiansheng.com
 * @param 
 * @return 
 * 2019年6月19日
 */
    private  String getToken() {
        String accessTokenUrl = WeiXinApiLinks.access_token.replace("APPID", WeiXinKeyInformation.APPID).replace("APPSECRET", WeiXinKeyInformation.APPSECRET);
        String url = UrlRele.get(accessTokenUrl);
        JSONObject jsonObject = JSONObject.parseObject(url);
        System.out.println("<>>>>>>>>>>>>>>>>>>>>>>>"+ jsonObject);
        String access_token = jsonObject.getString("access_token");
        String expiresIn = jsonObject.getString("expires_in");
        Map<String, Object> dataMap = new HashMap<String, Object>();
        dataMap.put(WeiXinKeyInformation.ACCESS_TOKEN, access_token);
        dataMap.put(WeiXinKeyInformation.ACCESS_TOKEN, System.currentTimeMillis());
        dataMap.put(WeiXinKeyInformation.EXPIRES_IN, expiresIn);
        //redisUtil.setCacheMap(WeiXinKeyInformation.WEIXIN_KEY, dataMap);
        accsessToken = new AccsessToken(access_token,Integer.parseInt(expiresIn));
        return access_token;
     }

    
    
    
    
    class AccsessToken {
    	/**
    	 * accessToken
    	 */
    	private String accessToken;
    	
    	/**
    	 * 获取accessToken时间
    	 */
    	private Long accessTokenTime;
    	
    	/**
    	 * accessToken有效期
    	 */
    	private Integer expiresIn;
    	AccsessToken(String accessToken ,int expiresIn){
    		this.accessTokenTime = System.currentTimeMillis();
    		this.accessToken = accessToken;
    		this.expiresIn = expiresIn;
    	}

		public String getAccessToken() {
			return accessToken;
		}

		public void setAccessToken(String accessToken) {
			this.accessToken = accessToken;
		}

		public long getAccessTokenTime() {
			return accessTokenTime;
		}

		public void setAccessTokenTime(long currentTime) {
			this.accessTokenTime = currentTime;
		}

		public Integer getExpiresIn() {
			return expiresIn;
		}

		public void setExpiresIn(Integer expiresIn) {
			this.expiresIn = expiresIn;
		}
    	
		/***
		 * 
		  * 功能描述: 当前accessToken是否有效
		 * @author tianlong@cdtiansheng.com
		 * @param 
		 * @return 
		 * 2019年6月21日
		 */
    	public boolean beExpire() {
    		long nowTime = System.currentTimeMillis();
    		long accessTokenTime = this.accessTokenTime;
    		if(nowTime - accessTokenTime > this.expiresIn) {
    			return false;
    		}
    		return true;
    	}
    	
    	
    }





	@Override
	public String createQrcode() {
		String qrCodeTicket = createQrcodeTicket();
		System.out.println(qrCodeTicket);
		return WeiXinApiLinks.qrcode.replace("TICKET", qrCodeTicket);
	}



	@Override
	public String createQrcodeTicket() {
		 String accessToken = getToken();
		String url =  WeiXinApiLinks.qrcode_token.replace("TOKEN", accessToken);
		//临时字符串二维码
		String data = "{\"expire_seconds\": 600, \"action_name\": \"QR_STR_SCENE\", \"action_info\": {\"scene\": {\"scene_str\": \"https://www.runoob.com/redis/redis-install.html\"}}}";
		String jsonStr = UrlRele.post(url, data);
		return JSONObject.parseObject(jsonStr).getString("ticket");
		  
	}

	@Override
	public Map<String,Object> createMenu(String jsonStrForMenus) {
		String accessToken =  getAccessToken();
		String url = WeiXinApiLinks.create_menu.replace("ACCESS_TOKEN",accessToken);
		String jsonStr = UrlRele.post(url, jsonStrForMenus);

		Map<String,Object> result = new HashMap<String,Object>();
		JSONObject object = JSONObject.parseObject(jsonStr);

		String  betrue =  object.getString("errmsg");
		if(betrue.equalsIgnoreCase("ok")){
			result.put("status",true);
			result.put("errcode",object.getString("errcode"));
			return result;
		} else{
			result.put("status",false);
			result.put("errcode",object.getString("errcode"));
			result.put("msg",object.getString("errmsg"));
			return result;
		}
    }

	@Override
	public String getAuthorizationToken(String code) {
    	String url = WeiXinApiLinks.AUTHORIZATION_TOKEN
				      .replace("APPID",WeiXinKeyInformation.APPID)
				      .replace("SECRET",WeiXinKeyInformation.APPSECRET)
				      .replace("CODE",code);
		String result = UrlRele.get(url);
		/**
		 * {"access_token":"22_imCfS9tpSC2C2B9cEAhFsbzMY-D58UbGJQZHlEEt-TXTA5N-TdgqxokRb_gXfrEQ34ixjo_zO2D5tZMe3EF8rk-ssfGjcvb_VqZT5Y90csk",
		 * "expires_in":7200,
		 * "refresh_token":"22_TxqYQyRBG53e6los6yw7D8-vvsMXz879jI1Z0bqHOw4VjEJaJ_RXTvH2IVXtukoYrOOBLiqhd1gNCo4srM6Nhd0H9Fppb5D4QJWLPV2CTs0",
		 * "openid":"o2o9A1XoMVTr57EtXeQroHkzyP1g",
		 * "scope":"snsapi_userinfo"}

		 */
		System.out.println(result);
		return result;
	}

	@Override
	public String getUserInfo(String openId) {
		return null;
	}

	/**
	 * https://open.weixin.qq.com/connect/oauth2/authorize?
	 * appid=wx58338a75ff5857bd&redirect_uri=http%3A%2F%2Ftianlong0810.top%2Fweixin%2FweixinCallback.htm&
	 * response_type=code&scope=snsapi_userinfo&state=STATE#wechat_redirect
	 * @param resultUrl
	 */
    @Override
    public String obtainauthorizecode(String resultUrl,String scope) {
    	return WeiXinApiLinks.AUTHORIZE_CODE_URL.replace("APPID",WeiXinKeyInformation.APPID)
				.replace("SCOPE",scope)
				.replace("REDIRECT_URI",resultUrl);
		 
    }
}
