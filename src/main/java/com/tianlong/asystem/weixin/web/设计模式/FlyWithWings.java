package com.tianlong.asystem.weixin.web.设计模式;

/**
 * @program: asystem
 * @description: 可以飞翔
 * @author: tianlong@cdtiansheng.com
 * @create: 2019-08-22 16:10
 **/

public class FlyWithWings  implements  FlyBehaiver{
    private String flyType = "我使用翅膀飞翔";

    public FlyWithWings(){

    }
    public FlyWithWings(String flyType){
        this.flyType = flyType;
    }
    @Override
    public void fly() {
        System.out.println("飞翔方式 = "+flyType);
    }
}
