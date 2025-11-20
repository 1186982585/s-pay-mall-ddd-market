package com.example.domain.trade.service.settlement.factory;


import com.example.domain.trade.model.entity.GroupBuyTeamEntity;
import com.example.domain.trade.model.entity.MarketPayOrderEntity;
import com.example.domain.trade.model.entity.TradeSettlementRuleCommandEntity;
import com.example.domain.trade.model.entity.TradeSettlementRuleFilterBackEntity;
import com.example.domain.trade.service.settlement.filter.EndRuleFilter;
import com.example.domain.trade.service.settlement.filter.OutTradeNoRuleFilter;
import com.example.domain.trade.service.settlement.filter.SCRuleFilter;
import com.example.domain.trade.service.settlement.filter.SettableRuleFilter;
import com.example.types.design.framework.link.model2.LinkArmory;
import com.example.types.design.framework.link.model2.chain.BusinessLinkedList;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

/**
 * @Author cxj
 * @Date 2025/11/20 15:26
 * @Description:
 */
@Slf4j
@Service
public class TradeSettlementRuleFilterFactory {

    @Bean("tradeSettlementRuleFilter")
    public BusinessLinkedList<TradeSettlementRuleCommandEntity,
            TradeSettlementRuleFilterFactory.DynamicContext, TradeSettlementRuleFilterBackEntity> tradeSettlementRuleFilter(
                    SCRuleFilter scRuleFilter,
                    OutTradeNoRuleFilter outTradeNoRuleFilter,
                    SettableRuleFilter settableRuleFilter,
                    EndRuleFilter endRuleFilter) {

        //组装链
        LinkArmory<TradeSettlementRuleCommandEntity, TradeSettlementRuleFilterFactory.DynamicContext, TradeSettlementRuleFilterBackEntity> linkArmory =
                new LinkArmory<>("交易结算规则过滤链", scRuleFilter, outTradeNoRuleFilter, settableRuleFilter, endRuleFilter);

        //链对象
        return linkArmory.getLogicLink();
    }

    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class DynamicContext {

        private MarketPayOrderEntity marketPayOrderEntity;
        private GroupBuyTeamEntity groupBuyTeamEntity;

    }
}
