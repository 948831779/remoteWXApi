package com.tianlong.asystem.weixin.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tianlong.asystem.weixin.web.service.CommdityService;
import com.tianlong.asystem.weixin.web.service.InvokingWeixinApi;

import java.util.concurrent.CountDownLatch;

@Controller
@RequestMapping("common")
public class PageController {
	
	@Autowired
	private InvokingWeixinApi invokingWeixinApi;
	
	 @Autowired
	    CommdityService commdityService;
	/**
	 * 
	  * 功能描述: 生成微信二维码
	 * @author tianlong@cdtiansheng.com
	 * @param 
	 * @return 
	 * 2019年6月21日
	 */

	private static Integer times = 1000;

	private CountDownLatch latch = new CountDownLatch(times);
	@RequestMapping(value = "createQrCode")
	@ResponseBody
	public String createQrCode(){
		return invokingWeixinApi.createQrcode();
	}
	
	@RequestMapping(value = "skipQrCode")
	public String skipQrCode(){
		return  "qrcode/weixinQrCode";
	}
	
	
	
	 @RequestMapping(value = "test")
 	    public void queryCommdityByCode(){
		 testCountDownLatch();
	    }

	public  void testCountDownLatch(){

		int threadCount = 1000;

		final CountDownLatch latch = new CountDownLatch(threadCount);

		for(int i=0; i< threadCount; i++){
			String code = i + " ";
			new Thread(new Runnable() {

				@Override
				public void run() {

					//System.out.println("线程" + Thread.currentThread().getId() + "开始出发");

					commdityService.queryByCodeBatch(code);

					//System.out.println("线程" + Thread.currentThread().getId() + "已到达终点");

					latch.countDown();
				}
			}).start();
		}

		try {
			latch.await();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.out.println("10个线程已经执行完毕！开始计算排名");
	}

}
