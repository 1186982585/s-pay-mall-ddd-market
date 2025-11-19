package com.example.domain.trade.service;

import com.example.domain.trade.model.entity.MarketPayOrderEntity;
import com.example.domain.trade.model.entity.PayActivityEntity;
import com.example.domain.trade.model.entity.PayDiscountEntity;
import com.example.domain.trade.model.entity.UserEntity;
import com.example.domain.trade.model.valobj.GroupBuyProgressVO;

/**
 * @Author cxj
 * @Date 2025/9/9 20:33
 * @Description:
 */
public interface ITradeOrderService {

    MarketPayOrderEntity queryNoPayMarketOrderByOutTradeNo(String userId, String outTradeNo);

    GroupBuyProgressVO queryGroupBuyProgress(String teamId);

    MarketPayOrderEntity lockMarketPayOrder(UserEntity userEntity, PayActivityEntity payActivityEntity, PayDiscountEntity payDiscountEntity) throws Exception;

}
