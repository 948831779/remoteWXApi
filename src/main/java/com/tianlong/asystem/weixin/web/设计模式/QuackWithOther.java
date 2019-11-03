package com.tianlong.asystem.weixin.web.设计模式;

/**
 * @program: asystem
 * @description: 叫
 * @author: tianlong@cdtiansheng.com
 * @create: 2019-08-22 16:19
 **/

public class QuackWithOther implements QuackBehaiver{
    @Override
    public void quack() {
        System.out.println("大声尖叫");
    }
}
