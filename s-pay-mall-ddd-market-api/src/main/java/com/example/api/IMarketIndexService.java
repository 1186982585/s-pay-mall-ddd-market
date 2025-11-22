package com.example.api;

import com.example.api.dto.GoodsMarketRequestDTO;
import com.example.api.dto.GoodsMarketResponseDTO;
import com.example.api.response.Response;

/**
 * @Author cxj
 * @Date 2025/11/21 20:52
 * @Description:
 */
public interface IMarketIndexService {

    /**
     * 查询拼团营销配置
     *
     * @param goodsMarketRequestDTO 营销商品信息
     * @return 营销配置信息
     */
    Response<GoodsMarketResponseDTO> queryGroupBuyMarketConfig(GoodsMarketRequestDTO goodsMarketRequestDTO);

}
