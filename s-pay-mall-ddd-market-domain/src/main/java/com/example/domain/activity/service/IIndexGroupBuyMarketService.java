package com.example.domain.activity.service;

import com.example.domain.activity.model.entity.MarketProductEntity;
import com.example.domain.activity.model.entity.TrialBalanceEntity;

/**
 * @Author cxj
 * @Date 2025/5/22 16:00
 * @Description:
 */
public interface IIndexGroupBuyMarketService {

    TrialBalanceEntity indexMarketTrial(MarketProductEntity marketProductEntity) throws Exception;

}
