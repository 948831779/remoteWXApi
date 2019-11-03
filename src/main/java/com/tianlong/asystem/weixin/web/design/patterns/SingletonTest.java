package com.tianlong.asystem.weixin.web.design.patterns;

/**
 * @program: asystem
 * @description: 单例模式测试
 *
 *
 * 双重检索机制
 * 懒汉模式
 * 饿汉模式
 * 枚举
 * @author: tianlong@cdtiansheng.com
 * @create: 2019-09-05 10:48
 **/

public class SingletonTest {
       private String persion;
    private String name;
    private Integer age;

    public String getPersion() {
        return persion;
    }

    public void setPersion(String persion) {
        this.persion = persion;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public SingletonTest getSingle() {
        return single;
    }

    public void setSingle(SingletonTest single) {
        this.single = single;
    }

    private volatile SingletonTest  single ;
 public SingletonTest getInstance(){
     if(single == null){
         synchronized (SingletonTest.class){
             if(single == null){
                 single = new SingletonTest();
              }
         }
     }
     return single;
 }

}
