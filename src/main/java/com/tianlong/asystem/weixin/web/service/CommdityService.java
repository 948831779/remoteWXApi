package com.tianlong.asystem.weixin.web.service;

import java.util.List;
import java.util.Map;

/**
 * @program: asystem
 * @description: 歌曲服务接口
 * @author: tianlong@cdtiansheng.com
 * @create: 2019-10-10 08:49
 **/
public interface CommdityService {
    /**
     * 单个查询
     * @param code
     * @return
     */
    Object queryByCode(String code);

    /**
     * 单个查询在实现类中批量
     * @param code
     * @return
     */
    Object queryByCodeBatch(String code);
    /**
     * 批量查询
     * @param listCodes
     * @return
     */
    Map<String ,Object> queryBatchByCodes(List<String> listCodes);
}
