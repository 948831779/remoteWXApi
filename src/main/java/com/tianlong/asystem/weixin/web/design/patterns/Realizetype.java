package com.tianlong.asystem.weixin.web.design.patterns;

/**
 * @program: asystem
 * @description: 原型模式
 * 原型模式包含以下主要角色。
 * 抽象原型类：规定了具体原型对象必须实现的接口。
 * 具体原型类：实现抽象原型类的 clone() 方法，它是可被复制的对象。
 * 访问类：使用具体原型类中的 clone() 方法来复制新的对象。
 * @author: tianlong@cdtiansheng.com
 * @create: 2019-09-05 10:33
 **/

public class Realizetype implements  Cloneable{

    private String zy;
    private Persion persion;

    public String getZy() {
        return zy;
    }

    public void setZy(String zy) {
        this.zy = zy;
    }

    public Persion getPersion() {
        return persion;
    }

    public void setPersion(Persion persion) {
        this.persion = persion;
    }

    @Override
    public Realizetype clone(){
        Realizetype type = null;
        try {
            type = (Realizetype)super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return type;
    }

    public static void main(String[] args) {
        Persion persion = new Persion();
        persion.setAge(20).setName("田龙");
        Realizetype type = new Realizetype();
        type.setPersion(persion);
        type.setZy("it");
        System.out.println( type.toString() );
        Realizetype type1 =type.clone();
        System.out.println( type1.toString() );

    }
}


class Persion{
    private String name ;
    private Integer age;

    public String getName() {
        return name;
    }

    public Persion setName(String name) {
        this.name = name;
        return this;
    }

    public Integer getAge() {
        return age;
    }

    public Persion setAge(Integer age) {
        this.age = age;
        return this;
    }
}
