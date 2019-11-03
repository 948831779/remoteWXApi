package com.tianlong.asystem.weixin.web.utils;

import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import com.thoughtworks.xstream.XStream;
import com.tianlong.asystem.weixin.web.entity.BaseMessage;

/**
 * 
 * 
  * 功能描述: xml解析
 * @author tianlong@cdtiansheng.com
 * @date 2019年6月16日 下午10:13:18
 * @version 1.0
 */
public class XmlUtils {
	/**
	 * 
	   * 功能描述: 解析xml
	 * @author tianlong@cdtiansheng.com
	 * @param 
	 * @return 
	 * 2019年6月16日
	 */
	public static Map<String, String> parseXml(HttpServletRequest request) {
		// 将解析结果存储在HashMap中
		Map<String, String> map = null;
		try {
			map = new HashMap<String, String>();
			// 读取输入流
			InputStream input = request.getInputStream();
			SAXReader reader = new SAXReader();
			Document document = reader.read(input);
			// 得到xml根元素
			Element root = document.getRootElement();
			// 得到根元素的所有子节点
			List<Element> elementList = root.elements();
			// 遍历所有子节点
			for (Element e : elementList) {
				map.put(e.getName(), e.getText());
			}
			// 释放资源
			input.close();
			input = null;
		} catch (Exception e) {
 			e.printStackTrace();
		} 
 		return map;
	}
	
	
	
	public static String beanToXml(BaseMessage text) {
		XStream xStream = new XStream();
 		xStream.processAnnotations(text.getClass());
		//调用toXML 将对象转成字符串
		String xml = xStream.toXML(text);
		System.out.println(xml);
		return xml;
	}
}
