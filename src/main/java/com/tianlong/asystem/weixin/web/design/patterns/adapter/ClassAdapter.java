package com.tianlong.asystem.weixin.web.design.patterns.adapter;

/**
 * @program: asystem
 * @description:
 * @author: tianlong@cdtiansheng.com
 * @create: 2019-09-05 17:17
 **/

public class ClassAdapter extends Adaptee implements Target {

    @Override
    public void request()
    {
        specificRequest();
    }
}