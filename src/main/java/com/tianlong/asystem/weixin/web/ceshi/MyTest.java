package com.tianlong.asystem.weixin.web.ceshi;

/**
 * @program: asystem
 * @description: 测试
 * @author: tianlong@cdtiansheng.com
 * @create: 2019-10-18 22:31
 **/
public interface MyTest {

    default  void test(){
        System.out.println("jdk8的新特性");
    }

   public  void operate(tianlong str);

}
