package com.tianlong.asystem.weixin.web.simulatedpersistenceLayer;

import java.util.List;
import java.util.Map;

/**
 * @program: asystem
 * @description: 模拟持久层获取数据
 * @author: tianlong@cdtiansheng.com
 * @create: 2019-10-10 08:51
 **/
public interface CommditySvc {

    /**
     * 单个查询
     * @param code
     * @return
     */
    Object queryByCode(String code);

    /**
     * 批量查询
     * @param listCodes
     * @return
     */
    Map<String ,Object> queryBatchByCodes(List<String> listCodes);

}
