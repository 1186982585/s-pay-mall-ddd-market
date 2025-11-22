package com.example.domain.activity.adapter.repository;

import com.example.domain.activity.model.entity.UserGroupBuyOrderDetailEntity;
import com.example.domain.activity.model.valobj.GroupBuyActivityDiscountVO;
import com.example.domain.activity.model.valobj.SCSkuActivityVO;
import com.example.domain.activity.model.valobj.SkuVO;
import com.example.domain.activity.model.valobj.TeamStatisticVO;

import java.util.List;

/**
 * @Author cxj
 * @Date 2025/5/25 22:08
 * @Description:
 */
public interface IActivityRepository {

    SkuVO querySkuByGoodsId(String goodsId);

    GroupBuyActivityDiscountVO queryGroupBuyActivityDiscountVO(Long activityId);

    SCSkuActivityVO querySCSkuActivityBySCGoodsId(String source, String channel, String goodsId);

    boolean isTagCrowdRange(String tagId, String userId);

    boolean downgradeSwitch();

    boolean cutRange(String userId);

    List<UserGroupBuyOrderDetailEntity> queryInProgressUserGroupBuyOrderDetailListByOwner(Long activityId, String userId, Integer ownerCount);

    List<UserGroupBuyOrderDetailEntity> queryInProgressUserGroupBuyOrderDetailListByRandom(Long activityId, String userId, Integer randomCount);

    TeamStatisticVO queryTeamStatisticByActivityId(Long activityId);
}
