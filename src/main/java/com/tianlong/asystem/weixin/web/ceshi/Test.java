package com.tianlong.asystem.weixin.web.ceshi;

/**
 * @program: asystem
 * @description:
 * @author: tianlong@cdtiansheng.com
 * @create: 2019-10-18 22:33
 **/

public class Test {


    public  static  MyTest ss(){
      return  new MyTest(){
            @Override
            public void operate(tianlong str){

                System.out.println("成都市");
            }
        };
    }
    public static void main(String[] args) {
        MyTest test =  ss();
        tianlong str = new tianlong();
        test.operate(str);
        test.test();

    }
}
