package com.tianlong.asystem.weixin.web.data.structure;

import java.util.HashMap;
import java.util.Hashtable;

/**
 * @program: asystem
 * @description: Hashtable数据结构
 * 左移右移 ： 实质上是将十进制转为二进制再向左移或者向右移动 ；左移动： n^n
 * @author: tianlong@cdtiansheng.com
 * @create: 2019-08-15 08:48
 **/

public class HashtableTest {
    public static void main(String[] args) {
        Hashtable table  = new Hashtable(5);
        table.put("1","6");
        table.put("2","5");
        table.put("3","1");
        table.put("4","2");
        table.put("5","3");
        table.put("6","4");
        table.put("7","7");
        table.put("8","8");
        table.put("9","9");
        table.put("10","10");


        for(Object t :table.keySet()){
            System.out.println("key = "+t +"   , value = "+table.get(t) + "   " +table.size());
        }

        HashMap <String,Object> map = new HashMap<>(10);
        map.put("12","asd");
        int h = "13213123".hashCode();
        System.out.println(  h + "   = " +(h ^(h >>> 16) ) );
//  00 01 10     <<<  10000

        int  i = 2 << 4;
        System.out.println(i +"    "+Integer.parseInt("100000",2));
    }
}
