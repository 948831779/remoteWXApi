package com.tianlong.asystem.weixin.web.design.patterns.proxy;

/**
 * @program: asystem
 * @description:
 * @author: tianlong@cdtiansheng.com
 * @create: 2019-09-05 11:20
 **/

public class test {
    public static void main(String[] args) {
        proxyTest logHandler=new proxyTest();
        UserManager userManager=(UserManager)logHandler.newProxyInstance(new UserManagerImpl());
        //UserManager userManager=new UserManagerImpl();
        userManager.addUser("1111", "张三");
    }
}
