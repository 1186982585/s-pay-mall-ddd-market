package com.example.domain.activity.service.trial.node;


import com.example.domain.activity.model.entity.MarketProductEntity;
import com.example.domain.activity.model.entity.TrialBalanceEntity;
import com.example.domain.activity.service.trial.AbstractGroupBuyMarketSupport;
import com.example.domain.activity.service.trial.factory.DefaultActivityStrategyFactory;
import com.example.types.design.framework.tree.StrategyHandler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Author cxj
 * @Date 2025/5/22 15:41
 * @Description:
 */
@Slf4j
@Service
public class RootNode extends AbstractGroupBuyMarketSupport<MarketProductEntity, DefaultActivityStrategyFactory.DynamicContext, TrialBalanceEntity> {

    @Resource
    private SwitchRoot switchRoot;

    @Override
    public TrialBalanceEntity apply(MarketProductEntity requestParameter, DefaultActivityStrategyFactory.DynamicContext dynamicContext) throws Exception {

//设置值，下一个节点可以用        dynamicContext.xxx

        return null;
    }

    @Override
    public StrategyHandler<MarketProductEntity, DefaultActivityStrategyFactory.DynamicContext, TrialBalanceEntity> get(MarketProductEntity requestParameter, DefaultActivityStrategyFactory.DynamicContext dynamicContext) {
        return switchRoot;
    }


}
