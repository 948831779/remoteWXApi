package com.tianlong.asystem.weixin.web.entity.menu;

/**
 * @program: asystem
 * @description: 点击button
 * @author: tianl
 * @create: 2019-06-22 21:37
 **/

public class ClickButton  extends  AbstractButon{

    private String type;
    private String key;
    public ClickButton(String name,String key){
        super(name);
        this.key = key;
        this.type = "click";
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }
}
