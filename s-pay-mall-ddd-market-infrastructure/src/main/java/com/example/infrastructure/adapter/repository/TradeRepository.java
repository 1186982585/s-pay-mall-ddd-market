package com.example.infrastructure.adapter.repository;

import com.example.domain.trade.adapter.repository.ITradeRepository;
import com.example.domain.trade.model.aggregate.GroupBuyOrderAggregate;
import com.example.domain.trade.model.entity.MarketPayOrderEntity;
import com.example.domain.trade.model.entity.PayActivityEntity;
import com.example.domain.trade.model.entity.PayDiscountEntity;
import com.example.domain.trade.model.entity.UserEntity;
import com.example.domain.trade.model.valobj.GroupBuyProgressVO;
import com.example.domain.trade.model.valobj.TradeOrderStatusEnumVO;
import com.example.infrastructure.dao.IGroupBuyOrderDao;
import com.example.infrastructure.dao.IGroupBuyOrderListDao;
import com.example.infrastructure.dao.po.GroupBuyOrder;
import com.example.infrastructure.dao.po.GroupBuyOrderList;
import com.example.types.enums.ResponseCode;
import com.example.types.exception.AppException;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * @Author cxj
 * @Date 2025/9/9 21:02
 * @Description:
 */
@Repository
public class TradeRepository implements ITradeRepository {

    @Resource
    private IGroupBuyOrderDao groupBuyOrderDao;

    @Resource
    private IGroupBuyOrderListDao groupBuyOrderListDao;

    @Override
    public MarketPayOrderEntity queryNoPayMarketPayOrderByOutTradeNo(String userId, String outTradeNo) {
        GroupBuyOrderList groupBuyOrderListReq = new GroupBuyOrderList();
        groupBuyOrderListReq.setUserId(userId);
        groupBuyOrderListReq.setOutTradeNo(outTradeNo);
        GroupBuyOrderList groupBuyOrderListRes = groupBuyOrderListDao.queryGroupBuyOrderRecordByOutTradeNo(groupBuyOrderListReq);

        if (null == groupBuyOrderListRes) return null;

        return MarketPayOrderEntity.builder()
                  .orderId(groupBuyOrderListRes.getOrderId())
                  .deductionPrice(groupBuyOrderListRes.getDeductionPrice())
                  .tradeOrderStatusEnumVO(TradeOrderStatusEnumVO.valueOf(groupBuyOrderListRes.getStatus()))
                  .build();

    }

    @Override
    public GroupBuyProgressVO queryGroupBuyProgress(String teamId) {
        GroupBuyOrder groupBuyOrder = groupBuyOrderDao.queryGroupBuyProgress(teamId);
        if (null == groupBuyOrder) return null;

        return GroupBuyProgressVO.builder()
                  .targetCount(groupBuyOrder.getTargetCount())
                  .completeCount(groupBuyOrder.getCompleteCount())
                  .lockCount(groupBuyOrder.getLockCount())
                  .build();
    }

    @Transactional(timeout = 500)
    @Override
    public MarketPayOrderEntity lockMarketPayOrder(GroupBuyOrderAggregate groupBuyOrderAggregate) {

        // 聚合对象信息
        UserEntity userEntity = groupBuyOrderAggregate.getUserEntity();
        PayActivityEntity payActivityEntity = groupBuyOrderAggregate.getPayActivityEntity();
        PayDiscountEntity payDiscountEntity = groupBuyOrderAggregate.getPayDiscountEntity();

        String teamId = payActivityEntity.getTeamId();

        if (StringUtils.isBlank(teamId)) {
            teamId = RandomStringUtils.randomNumeric(8);

            // 构建拼团订单
            GroupBuyOrder groupBuyOrder = GroupBuyOrder.builder()
                    .teamId(teamId)
                    .activityId(payActivityEntity.getActivityId())
                    .source(payDiscountEntity.getSource())
                    .channel(payDiscountEntity.getChannel())
                    .originalPrice(payDiscountEntity.getOriginalPrice())
                    .deductionPrice(payDiscountEntity.getDeductionPrice())
                    .payPrice(payDiscountEntity.getDeductionPrice().subtract(payDiscountEntity.getDeductionPrice()))
                    .targetCount(payActivityEntity.getTargetCount())
                    .completeCount(0)
                    .lockCount(1)
                    .build();

            groupBuyOrderDao.insert(groupBuyOrder);
        } else {
            int updateAddLockCount = groupBuyOrderDao.updateAddLockCount(teamId);
            if (1!=updateAddLockCount) {
                throw new AppException(ResponseCode.E0005);
            }
        }

        String orderId = RandomStringUtils.randomNumeric(12);

        GroupBuyOrderList groupBuyOrderListReq = GroupBuyOrderList.builder()
                .userId(userEntity.getUserId())
                .teamId(teamId)
                .orderId(orderId)
                .activityId(payActivityEntity.getActivityId())
                .startTime(payActivityEntity.getStartTime())
                .endTime(payActivityEntity.getEndTime())
                .goodsId(payDiscountEntity.getGoodsId())
                .source(payDiscountEntity.getSource())
                .channel(payDiscountEntity.getChannel())
                .originalPrice(payDiscountEntity.getOriginalPrice())
                .deductionPrice(payDiscountEntity.getDeductionPrice())
                .status(TradeOrderStatusEnumVO.CREATE.getCode())
                .outTradeNo(payDiscountEntity.getOutTradeNo())
                .build();

        try {
            groupBuyOrderListDao.insert(groupBuyOrderListReq);
        }catch (DuplicateKeyException e){
            throw new AppException(ResponseCode.INDEX_EXCEPTION);
        }

        return MarketPayOrderEntity.builder()
                .orderId(orderId)
                .deductionPrice(payDiscountEntity.getDeductionPrice())
                .tradeOrderStatusEnumVO(TradeOrderStatusEnumVO.CREATE)
                .build();
    }
}
