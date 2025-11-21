package com.example.domain.trade.adapter.port;

import com.example.domain.trade.model.entity.NotifyTaskEntity;

/**
 * @Author cxj
 * @Date 2025/11/20 20:04
 * @Description: 交易接口服务接口
 */
public interface ITradePort {

    String groupBuyNotify(NotifyTaskEntity notifyTask) throws Exception;

}
