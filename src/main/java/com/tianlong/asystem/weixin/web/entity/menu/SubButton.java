package com.tianlong.asystem.weixin.web.entity.menu;

import com.thoughtworks.xstream.annotations.XStreamAlias;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: asystem
 * @description: 二级菜单
 * @author: tianl
 * @create: 2019-06-22 21:42
 **/

 public class SubButton  extends  AbstractButon{

     private List<AbstractButon>  sub_button = new ArrayList<AbstractButon>();

    

    public List<AbstractButon> getSub_button() {
		return sub_button;
	}



	public void setSub_button(List<AbstractButon> sub_button) {
		this.sub_button = sub_button;
	}



	public SubButton( String name) {
         super(name);
    }
}
