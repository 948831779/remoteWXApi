package com.tianlong.asystem.weixin.web.设计模式;

/**
 * @program: asystem
 * @description: 鸭子的抽象类
 * @author: tianlong@cdtiansheng.com
 * @create: 2019-08-22 15:42
 **/

public  abstract class Duck {
    FlyBehaiver flyBehaiver;
    QuackBehaiver quackBehaiver;

    public Duck(){

    }
 public void performFly(){
     flyBehaiver.fly();
 }

 public void performQuack(){
     quackBehaiver.quack();
 }


 public void swim(){
     System.out.println("   i'm  swimming ");
 }

    public FlyBehaiver getFlyBehaiver() {
        return flyBehaiver;
    }

    public void setFlyBehaiver(FlyBehaiver flyBehaiver) {
        this.flyBehaiver = flyBehaiver;
    }

    public QuackBehaiver getQuackBehaiver() {
        return quackBehaiver;
    }

    public void setQuackBehaiver(QuackBehaiver quackBehaiver) {
        this.quackBehaiver = quackBehaiver;
    }
}
