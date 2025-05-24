package com.example.domain.activity.service;

import com.example.domain.activity.model.entity.MarketProductEntity;
import com.example.domain.activity.model.entity.TrialBalanceEntity;
import com.example.domain.activity.service.trial.factory.DefaultActivityStrategyFactory;
import com.example.types.design.framework.tree.StrategyHandler;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Author cxj
 * @Date 2025/5/22 16:02
 * @Description:
 */
@Service
public class IndexGroupBuyMarketServiceImpl implements IIndexGroupBuyMarketService{

    @Resource
    private DefaultActivityStrategyFactory defaultActivityStrategyFactory;

    @Override
    public TrialBalanceEntity indexMarketTrial(MarketProductEntity marketProductEntity) throws Exception {

        StrategyHandler<MarketProductEntity, DefaultActivityStrategyFactory.DynamicContext, TrialBalanceEntity> strategyHandler = defaultActivityStrategyFactory.strategyHandler();

        TrialBalanceEntity trialBalanceEntity = strategyHandler.apply(marketProductEntity, new DefaultActivityStrategyFactory.DynamicContext());

        return trialBalanceEntity;
    }

}
