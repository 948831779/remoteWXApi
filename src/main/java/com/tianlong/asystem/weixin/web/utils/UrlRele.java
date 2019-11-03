package com.tianlong.asystem.weixin.web.utils;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;

import org.apache.commons.lang3.StringUtils;

import com.alibaba.fastjson.JSONObject;

/**
 * 
 * 
  *  get/post
 * @author tianlong@cdtiansheng.com
 * @date Jan 28, 2019 3:29:25 PM
 * @version 1.0
 */
public class UrlRele {
	
	
	public static String get(String requestUrl) {
		String message = null;
		if(StringUtils.isNotBlank(requestUrl)) {
			  try {
				// /1、解决https请求的问题
		 			// 创建SSLContext对象，并使用我们指定的信任管理器初始化
					TrustManager[] tm = { new MyX509TrustManager() };
					SSLContext sslContext = SSLContext.getInstance("SSL", "SunJSSE");
					sslContext.init(null, tm, new java.security.SecureRandom());
					// 从上述SSLContext对象中得到SSLSocketFactory对象
					SSLSocketFactory ssf = sslContext.getSocketFactory();
	 				URL url = new URL(requestUrl);
					HttpsURLConnection connection = (HttpsURLConnection) url
							.openConnection();
					connection.setSSLSocketFactory(ssf);
				 connection.setRequestMethod("GET");
	    	     connection.setDoOutput(true);
	    	     connection.setDoInput(true);
	    	     connection.connect();
	     	     InputStream inputStream = connection.getInputStream();
	    	     int size =inputStream.available();
	    	     byte[] bs =new byte[size];
	    	     inputStream.read(bs);
	    	     message = new String(bs,"UTF-8");
			} catch ( Exception e) {
	 			e.printStackTrace();
			}
			return message;
		}else {
			try {
				throw new Exception("url is not null");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return message;
		}
	}
	
	public static String post(String requestUrl, String data) {
		String message = null;
		try {
			// /1、解决https请求的问题
			// 创建SSLContext对象，并使用我们指定的信任管理器初始化
			TrustManager[] tm = { new MyX509TrustManager() };
			SSLContext sslContext = SSLContext.getInstance("SSL", "SunJSSE");
			sslContext.init(null, tm, new java.security.SecureRandom());
			// 从上述SSLContext对象中得到SSLSocketFactory对象
			SSLSocketFactory ssf = sslContext.getSocketFactory();

			URL url = new URL(requestUrl);
			HttpsURLConnection connection = (HttpsURLConnection) url.openConnection();
			connection.setSSLSocketFactory(ssf);
			connection.setDoOutput(true);
			connection.setDoInput(true);
			connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
			connection.setRequestProperty("Connection", "Keep-Alive");
			connection.setRequestProperty("Charset", "UTF-8");
			connection.setRequestMethod("POST");

			if (null != data) {
				OutputStream os = connection.getOutputStream();
				os.write(data.getBytes());
				os.close();
			}

			connection.connect();
			InputStream inputStream = connection.getInputStream();
			int size = inputStream.available();
			byte[] bs = new byte[size];
			inputStream.read(bs);
			message = new String(bs, "UTF-8");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return message;
	}
	
	
	/**
	 * 
	 * @comment 自己决定post、get
	 * @author tianlong@cdtiansheng.com
	 * @param 
	 * @return 
	 * Jan 30, 2019
	 * @throws Exception 
	 */
	public static JSONObject httpRequest(String requestUrl,
			String requestMethod, String outputStr) throws Exception {
		JSONObject jsonObject = null;
		StringBuffer buffer = new StringBuffer();
 			// /1、解决https请求的问题
 			// 创建SSLContext对象，并使用我们指定的信任管理器初始化
			TrustManager[] tm = { new MyX509TrustManager() };
			SSLContext sslContext = SSLContext.getInstance("SSL", "SunJSSE");
			sslContext.init(null, tm, new java.security.SecureRandom());
			// 从上述SSLContext对象中得到SSLSocketFactory对象
			SSLSocketFactory ssf = sslContext.getSocketFactory();
 			URL url = new URL(requestUrl);
			HttpsURLConnection httpUrlConn = (HttpsURLConnection) url
					.openConnection();
			httpUrlConn.setSSLSocketFactory(ssf);
 			httpUrlConn.setDoOutput(true);
			httpUrlConn.setDoInput(true);
			httpUrlConn.setUseCaches(false);
			//System.out.println("----------------------------------->>>>>>>>>>   进入httpRequest" );
 			// /2、兼容GET、POST两种方式
 			// 设置请求方式（GET/POST）
			httpUrlConn.setRequestMethod(requestMethod);
 			if ("GET".equalsIgnoreCase(requestMethod)) {
				httpUrlConn.connect();
			}
 			// /3、兼容有数据提交、无数据提交两种情况
 			// 当有数据需要提交时
			if (null != outputStr) {
				OutputStream outputStream = httpUrlConn.getOutputStream();
				// 注意编码格式，防止中文乱码
				outputStream.write(outputStr.getBytes("UTF-8"));
				outputStream.close();
			}
 			// 将返回的输入流转换成字符串
			InputStream inputStream = httpUrlConn.getInputStream();
			InputStreamReader inputStreamReader = new InputStreamReader(
					inputStream, "utf-8");
			BufferedReader bufferedReader = new BufferedReader(
					inputStreamReader);
 			String str = null;
			while ((str = bufferedReader.readLine()) != null) {
				buffer.append(str);
			}
			//System.out.println("回复内容：   --------------------->>>>>>>>>>"+buffer.toString());
			bufferedReader.close();
			inputStreamReader.close();
			// 释放资源
			inputStream.close();
			inputStream = null;
			httpUrlConn.disconnect();
			jsonObject = JSONObject.parseObject(buffer.toString());
 		return jsonObject;
	}

}
