package com.tianlong.asystem.weixin.web.design.patterns.proxy;

/**
 * @program: asystem
 * @description:
 * @author: tianlong@cdtiansheng.com
 * @create: 2019-09-05 11:13
 **/
public interface UserManager {
     void addUser(String userId, String userName);
     void delUser(String userId);
     String findUser(String userId);
    void modifyUser(String userId, String userName);

}
