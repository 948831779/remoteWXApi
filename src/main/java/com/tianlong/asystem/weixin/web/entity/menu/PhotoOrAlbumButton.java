package com.tianlong.asystem.weixin.web.entity.menu;

import java.util.ArrayList;
import java.util.List;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * @program: asystem
 * @description: 拍照或者相册发图
 * @author: tianl
 * @create: 2019-06-22 22:12
 **/

public class PhotoOrAlbumButton extends AbstractButon {

    private String type;
    private String key;
    
     private List<AbstractButon> sub_button = new ArrayList<AbstractButon>();
    public PhotoOrAlbumButton(String name,String key) {
        super(name);
        this.key = key;
        this.type = "pic_photo_or_album";
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
	public List<AbstractButon> getSub_button() {
		return sub_button;
	}
	public void setSub_button(List<AbstractButon> sub_button) {
		this.sub_button = sub_button;
	}
	 
    
    
    
}
