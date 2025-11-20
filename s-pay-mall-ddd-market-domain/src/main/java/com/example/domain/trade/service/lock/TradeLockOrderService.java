package com.example.domain.trade.service.lock;

import com.example.domain.trade.adapter.repository.ITradeRepository;
import com.example.domain.trade.model.aggregate.GroupBuyOrderAggregate;
import com.example.domain.trade.model.entity.*;
import com.example.domain.trade.model.valobj.GroupBuyProgressVO;
import com.example.domain.trade.service.ITradeLockOrderService;
import com.example.domain.trade.service.lock.factory.TradeLockRuleFilterFactory;
import com.example.types.design.framework.link.model2.chain.BusinessLinkedList;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Author cxj
 * @Date 2025/9/9 20:52
 * @Description:
 */
@Service
public class TradeLockOrderService implements ITradeLockOrderService {

    @Resource
    private ITradeRepository repository;
    @Resource
    private BusinessLinkedList<TradeLockRuleCommandEntity, TradeLockRuleFilterFactory.DynamicContext, TradeLockRuleFilterBackEntity> tradeRuleFilter;


    @Override
    public MarketPayOrderEntity queryNoPayMarketOrderByOutTradeNo(String userId, String outTradeNo) {
        return repository.queryNoPayMarketPayOrderByOutTradeNo(userId, outTradeNo);
    }

    @Override
    public GroupBuyProgressVO queryGroupBuyProgress(String teamId) {
        return repository.queryGroupBuyProgress(teamId);
    }

    @Override
    public MarketPayOrderEntity lockMarketPayOrder(UserEntity userEntity, PayActivityEntity payActivityEntity, PayDiscountEntity payDiscountEntity) throws Exception{

        // 交易规则过滤
        TradeLockRuleFilterBackEntity tradeLockRuleFilterBackEntity = tradeRuleFilter.apply(TradeLockRuleCommandEntity.builder()
                        .activityId(payActivityEntity.getActivityId())
                        .userId(userEntity.getUserId())
                        .build(),
                new TradeLockRuleFilterFactory.DynamicContext());

        // 已参与拼团量 - 用于构建数据库唯一索引使用，确保用户只能在一个活动上参与固定的次数
        Integer userTakeOrderCount = tradeLockRuleFilterBackEntity.getUserTakeOrderCount();

        GroupBuyOrderAggregate groupBuyOrderAggregate = GroupBuyOrderAggregate.builder()
                .userEntity(userEntity)
                .payActivityEntity(payActivityEntity)
                .payDiscountEntity(payDiscountEntity)
                .userTakeOrderCount(userTakeOrderCount)
                .build();
        return repository.lockMarketPayOrder(groupBuyOrderAggregate);
    }
}
