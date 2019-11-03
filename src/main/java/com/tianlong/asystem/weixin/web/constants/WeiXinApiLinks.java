package com.tianlong.asystem.weixin.web.constants;

/**
 * @program: asystem
 * @description: 调用微信api先关链接
 * @author: tianl
 * @create: 2019-06-19 21:46
 **/

public final class WeiXinApiLinks {

    /**
     * 获取access_token连接
     */
	public static String access_token = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=APPID&secret=APPSECRET";


    /**
     *  得到openid
     */
    public final static String get_token_url="https://api.weixin.qq.com/sns/oauth2/access_token?appid=APPID&secret=SECRET&code=CODE&grant_type=authorization_code";

    
    
    /**
               * 获取微信二维码token
     */
    public final static String qrcode_token = "https://api.weixin.qq.com/cgi-bin/qrcode/create?access_token=TOKEN";


    /**
     * 生成二维码
     */
    public final static String qrcode  ="https://mp.weixin.qq.com/cgi-bin/showqrcode?ticket=TICKET";

    /**
     * 创建菜单
     */
    public static final  String create_menu = "https://api.weixin.qq.com/cgi-bin/menu/create?access_token=ACCESS_TOKEN";

    /**
     * 网页授权获取code
     */
    public static final String AUTHORIZE_CODE_URL = "https://open.weixin.qq.com/connect/oauth2/authorize?appid=APPID&redirect_uri=REDIRECT_URI&response_type=code&scope=SCOPE&state=STATE#wechat_redirect";
    /***
     * 获取网页授权access_token
     */
    public static final String AUTHORIZATION_TOKEN = "https://api.weixin.qq.com/sns/oauth2/access_token?appid=APPID&secret=SECRET&code=CODE&grant_type=authorization_code";

    /***
     * 获取用户信息url
     */
    public  static  final  String USERINFO_URL = "https://api.weixin.qq.com/sns/userinfo?access_token=ACCESS_TOKEN&openid=OPENID&lang=zh_CN";

}
