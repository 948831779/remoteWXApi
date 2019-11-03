package com.tianlong.asystem.weixin.web.jdk8.test;

/**
 * jdk8 01
 * @author Administrator
 *
 */
public class test01 {
	 final static String salutation = "Hello! ";
	   
	 public static void main(String[] args){
	      GreetingService greetService1 = (message) -> {System.out.println(salutation + message);} ;
	      greetService1.sayMessage("Runoob");
	       
	      
	   }
	    
	   interface GreetingService {
	      void sayMessage(String message);
	   }
}
