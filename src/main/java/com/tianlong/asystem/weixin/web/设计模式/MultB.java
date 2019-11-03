package com.tianlong.asystem.weixin.web.设计模式;

import java.util.Map;
import java.util.Observable;
import java.util.Observer;

/**
 * @program: asystem
 * @description:
 * @author: tianlong@cdtiansheng.com
 * @create: 2019-08-22 16:36
 **/

public class MultB extends Observable implements Observer {
    int data = 0;

      Map<String,Object> map ;
    public void setData(int i,Map<String,Object> map) {
        data = i;
        this.map = map;
        setChanged();    //标记此 Observable对象为已改变的对象
        notifyObservers();    //通知所有观察者
    }

    @Override
    public void update(Observable o, Object arg) {
        System.out.println("MultB观察到几乎同时MultA也有数据变化，貌似自己的变化被监听。。。。" );
    }
}
