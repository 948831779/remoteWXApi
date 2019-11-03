package com.tianlong.asystem.weixin.web.设计模式;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: asystem
 * @description:
 * @author: tianlong@cdtiansheng.com
 * @create: 2019-08-22 16:36
 **/

public class Test {
    public static void main(String[] args) {

        MultA multa = new MultA();
        MultB multb = new MultB();

        multb.addObserver(multa);
        multa.addObserver(multb);

        Map<String,Object> map = new HashMap<>(3);
        map.put("fgds","dsfdf");
        map.put("2","dsfdf");
        map.put("3","dsfdf");
        multb.setData(1,map);
    }
}
