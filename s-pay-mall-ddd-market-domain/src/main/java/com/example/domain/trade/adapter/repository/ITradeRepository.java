package com.example.domain.trade.adapter.repository;

import com.example.domain.trade.model.aggregate.GroupBuyOrderAggregate;
import com.example.domain.trade.model.aggregate.GroupBuyTeamSettlementAggregate;
import com.example.domain.trade.model.entity.GroupBuyActivityEntity;
import com.example.domain.trade.model.entity.GroupBuyTeamEntity;
import com.example.domain.trade.model.entity.MarketPayOrderEntity;
import com.example.domain.trade.model.valobj.GroupBuyProgressVO;

/**
 * @Author cxj
 * @Date 2025/9/9 20:54
 * @Description:
 */
public interface ITradeRepository {


    MarketPayOrderEntity queryNoPayMarketPayOrderByOutTradeNo(String userId, String outTradeNo);

    GroupBuyProgressVO queryGroupBuyProgress(String teamId);

    MarketPayOrderEntity lockMarketPayOrder(GroupBuyOrderAggregate groupBuyOrderAggregate);

    GroupBuyActivityEntity queryGroupBuyActivityEntityByActivityId(Long activityId);

    Integer queryOrderCountByActivityId(Long activityId, String userId);

    GroupBuyTeamEntity queryGroupBuyTeamByTeamId(String teamId);

    void settlementMarketPayOrder(GroupBuyTeamSettlementAggregate groupBuyTeamSettlementAggregate);

    boolean isSCBlackIntercept(String source, String channel);
}
