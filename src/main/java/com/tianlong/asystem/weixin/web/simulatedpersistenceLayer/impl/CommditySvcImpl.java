package com.tianlong.asystem.weixin.web.simulatedpersistenceLayer.impl;

import com.tianlong.asystem.weixin.web.simulatedpersistenceLayer.CommditySvc;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @program: asystem
 * @description: 模拟持久层实现类
 * @author: tianlong@cdtiansheng.com
 * @create: 2019-10-10 08:52
 **/

@Service
public class CommditySvcImpl implements CommditySvc {

    @Override
    public Object queryByCode(String code)  {

        try {
            //模拟数据库耗时
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return code +"的歌曲 ";
    }

    @Override
    public Map<String, Object> queryBatchByCodes(List<String> listCodes) {
        try {
            //模拟数据库耗时
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Map<String, Object> map = new HashMap<String, Object>(listCodes.size());
        for(String str: listCodes){
            map.put(str,str  +"的歌曲 ");
        }
        return map;
    }
}
