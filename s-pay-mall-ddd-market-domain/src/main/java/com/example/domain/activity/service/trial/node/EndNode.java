package com.example.domain.activity.service.trial.node;

import com.example.domain.activity.model.entity.MarketProductEntity;
import com.example.domain.activity.model.entity.TrialBalanceEntity;
import com.example.domain.activity.service.trial.AbstractGroupBuyMarketSupport;
import com.example.domain.activity.service.trial.factory.DefaultActivityStrategyFactory;
import com.example.types.design.framework.tree.StrategyHandler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @Author cxj
 * @Date 2025/5/22 15:59
 * @Description:
 */
@Slf4j
@Service
public class EndNode extends AbstractGroupBuyMarketSupport<MarketProductEntity, DefaultActivityStrategyFactory.DynamicContext, TrialBalanceEntity> {

    @Override
    public TrialBalanceEntity apply(MarketProductEntity requestParameter, DefaultActivityStrategyFactory.DynamicContext dynamicContext) throws Exception {
        return null;
    }

    @Override
    public StrategyHandler<MarketProductEntity, DefaultActivityStrategyFactory.DynamicContext, TrialBalanceEntity> get(MarketProductEntity requestParameter, DefaultActivityStrategyFactory.DynamicContext dynamicContext) {
        return null;
    }
}
