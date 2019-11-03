package com.tianlong.asystem.weixin.web.设计模式;

import java.util.Observable;
import java.util.Observer;

/**
 * @program: asystem
 * @description:
 * @author: tianlong@cdtiansheng.com
 * @create: 2019-08-22 16:35
 **/

public class MultA extends Observable implements Observer {
    @Override
    public void update(Observable o, Object arg) {
        MultB multb=(MultB) o;     //获取被观察者对象
        System.out.println("MultA监听到MultB数据变化：" +multb.data +",,"+multb.map +"  arg ="+arg);

        setChanged();
        notifyObservers();    //自己观察到数据变化，通知自己的观察者
    }
}
