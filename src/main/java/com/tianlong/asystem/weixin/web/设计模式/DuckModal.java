package com.tianlong.asystem.weixin.web.设计模式;

/**
 * @program: asystem
 * @description: 鸭子模型
 * @author: tianlong@cdtiansheng.com
 * @create: 2019-08-22 16:21
 **/

public class DuckModal extends Duck {
    public DuckModal() {
        super.flyBehaiver = new FlyWithOnWay();
        super.quackBehaiver = new QuackWithOther();
    }

    public static void main(String[] args) {
        Duck model = new DuckModal();
        model.performFly();
        model.setFlyBehaiver(new FlyWithWings("我使用螺旋桨飞翔"));
        model.performFly();
    }

}
