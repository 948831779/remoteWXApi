package com.tianlong.asystem.weixin.web.entity.menu;

import com.thoughtworks.xstream.annotations.XStreamAlias;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: asystem
 * @description: 按钮或点击菜单
 * @author: tianl
 * @create: 2019-06-22 21:18
 **/

@XStreamAlias(value = "button")
public class ButtonMenu {

    private List<AbstractButon> button = new ArrayList<AbstractButon>();

    public List<AbstractButon> getButton() {
        return button;
    }

    public void setButton(List<AbstractButon> button) {
        this.button = button;
    }


}
