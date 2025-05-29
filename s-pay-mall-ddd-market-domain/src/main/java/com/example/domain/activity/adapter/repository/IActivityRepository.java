package com.example.domain.activity.adapter.repository;

import com.example.domain.activity.model.valobj.GroupBuyActivityDiscountVO;
import com.example.domain.activity.model.valobj.SkuVO;

/**
 * @Author cxj
 * @Date 2025/5/25 22:08
 * @Description:
 */
public interface IActivityRepository {

    GroupBuyActivityDiscountVO queryGroupBuyActivityDiscountVO(String source, String channel);

    SkuVO querySkuByGoodsId(String goodsId);

}
