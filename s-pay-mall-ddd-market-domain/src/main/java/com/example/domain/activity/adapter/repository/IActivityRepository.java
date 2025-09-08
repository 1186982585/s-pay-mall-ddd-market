package com.example.domain.activity.adapter.repository;

import com.example.domain.activity.model.valobj.GroupBuyActivityDiscountVO;
import com.example.domain.activity.model.valobj.SCSkuActivityVO;
import com.example.domain.activity.model.valobj.SkuVO;

/**
 * @Author cxj
 * @Date 2025/5/25 22:08
 * @Description:
 */
public interface IActivityRepository {

    SkuVO querySkuByGoodsId(String goodsId);

    GroupBuyActivityDiscountVO queryGroupBuyActivityDiscountVO(Long activityId);

    SCSkuActivityVO querySCSkuActivityBySCGoodsId(String source, String channel, String goodsId);
}
