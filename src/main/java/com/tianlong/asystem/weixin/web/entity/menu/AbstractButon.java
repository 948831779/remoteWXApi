package com.tianlong.asystem.weixin.web.entity.menu;

/**
 * @program: asystem
 * @description:
 * @author: tianl
 * @create: 2019-06-22 21:27
 **/

public abstract class AbstractButon {

    private String name;

    public AbstractButon(String name) {
        this.name = name;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
