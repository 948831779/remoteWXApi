package com.tianlong.asystem.weixin.web.entity.menu;

/**
 * @program: asystem
 * @description: 跳转菜单
 * @author: tianl
 * @create: 2019-06-22 21:40
 **/

public class ViewButton extends AbstractButon {

    private String type;
    private String url;

    public ViewButton(String url,String name){
        super(name);
        this.url = url;
        this.type  = "view";
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }


    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
