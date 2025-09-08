package com.example.domain.activity.service.trial.thread;

import com.example.domain.activity.adapter.repository.IActivityRepository;
import com.example.domain.activity.model.valobj.SkuVO;

import java.util.concurrent.Callable;

/**
 * @Author cxj
 * @Date 2025/5/25 15:43
 * @Description: 查询商品信息任务
 */
public class QuerySkuVOFromDBThreadTask implements Callable<SkuVO> {

    private final String goodsId;

    private final IActivityRepository activityRepository;

    public QuerySkuVOFromDBThreadTask(String goodsId, IActivityRepository activityRepository) {
        this.goodsId = goodsId;
        this.activityRepository = activityRepository;
    }

    @Override
    public SkuVO call() throws Exception {
        return activityRepository.querySkuByGoodsId(goodsId);
    }

}
