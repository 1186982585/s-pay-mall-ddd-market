package com.example.infrastructure.dao;

import com.example.infrastructure.dao.po.GroupBuyActivity;
import com.example.infrastructure.dao.po.Sku;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Author cxj
 * @Date 2025/5/26 16:56 拼团活动Dao
 * @Description:
 */
@Mapper
public interface ISkuDao {

    Sku querySkuByGoodsId(String goodsId);

    GroupBuyActivity queryValidGroupBuyActivity(GroupBuyActivity groupBuyActivityReq);

}
