package com.example.domain.trade.service;

import com.example.domain.trade.model.entity.TradePaySettlementEntity;
import com.example.domain.trade.model.entity.TradePaySuccessEntity;

/**
 * @Author cxj
 * @Date 2025/11/20 8:58
 * @Description:
 */
public interface ITradeSettlementOrderService {

    TradePaySettlementEntity settlementMarketPayOrder(TradePaySuccessEntity tradePaySuccessEntity) throws Exception;

}
