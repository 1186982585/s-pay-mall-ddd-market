package com.example.domain.trade.service.settlement;

import com.example.domain.trade.adapter.repository.ITradeRepository;
import com.example.domain.trade.model.aggregate.GroupBuyTeamSettlementAggregate;
import com.example.domain.trade.model.entity.*;
import com.example.domain.trade.service.ITradeSettlementOrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Author cxj
 * @Date 2025/11/20 9:05
 * @Description:
 */
@Slf4j
@Service
public class TradeSettlementOrderService implements ITradeSettlementOrderService {

    @Resource
    private ITradeRepository repository;

    @Override
    public TradePaySettlementEntity settlementMarketPayOrder(TradePaySuccessEntity tradePaySuccessEntity) {

        log.info("tradePaySuccessEntity:{}", tradePaySuccessEntity);
        // 1.查询拼团信息
        MarketPayOrderEntity marketPayOrderEntity = repository.queryNoPayMarketPayOrderByOutTradeNo(tradePaySuccessEntity.getUserId(), tradePaySuccessEntity.getOutTradeNo());
        // 处于锁单状态才能查到，因为查找逻辑要求status=0.超时也查不到
        if (null == marketPayOrderEntity) {
            return null;
        }
        log.info("marketPayOrderEntity:{}", marketPayOrderEntity);

        // 2.查询拼团组队信息
        // 两种方式，一种根据参与时间(锁单)，一种根据支付时间
        GroupBuyTeamEntity groupBuyTeamEntity = repository.queryGroupBuyTeamByTeamId(marketPayOrderEntity.getTeamId());

        GroupBuyTeamSettlementAggregate groupBuyTeamSettlementAggregate = GroupBuyTeamSettlementAggregate.builder()
                .userEntity(UserEntity.builder().userId(tradePaySuccessEntity.getUserId()).build())
                .groupBuyTeamEntity(groupBuyTeamEntity)
                .tradePaySuccessEntity(tradePaySuccessEntity)
                .build();

        repository.settlementMarketPayOrder(groupBuyTeamSettlementAggregate);
        // 3.

        return TradePaySettlementEntity.builder()
                .source(tradePaySuccessEntity.getSource())
                .channel(tradePaySuccessEntity.getChannel())
                .userId(tradePaySuccessEntity.getUserId())
                .teamId(marketPayOrderEntity.getTeamId())
                .activityId(groupBuyTeamEntity.getActivityId())
                .outTradeNo(tradePaySuccessEntity.getOutTradeNo())
                .build();
    }

}
