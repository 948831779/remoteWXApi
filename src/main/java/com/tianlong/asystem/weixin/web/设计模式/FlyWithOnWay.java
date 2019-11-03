package com.tianlong.asystem.weixin.web.设计模式;

/**
 * @program: asystem
 * @description: 不能飞
 * @author: tianlong@cdtiansheng.com
 * @create: 2019-08-22 16:20
 **/

public class FlyWithOnWay implements  FlyBehaiver {
    @Override
    public void fly() {
        System.out.println("不能飞");
    }
}
