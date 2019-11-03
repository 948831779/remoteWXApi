package com.tianlong.asystem.weixin.web.design.patterns.adapter;

/**
 * @program: asystem
 * @description: 适配器
 * @author: tianlong@cdtiansheng.com
 * @create: 2019-09-05 17:13
 **/

public class adapterTest {
    public static void main(String[] args) {
        System.out.println("类适配器模式测试：");
        Target target = new ClassAdapter();
        target.request();
    }
}
