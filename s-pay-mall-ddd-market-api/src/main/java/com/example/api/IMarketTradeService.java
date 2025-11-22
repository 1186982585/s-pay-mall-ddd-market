package com.example.api;

import com.example.api.dto.LockMarketPayOrderRequestDTO;
import com.example.api.dto.LockMarketPayOrderResponseDTO;
import com.example.api.dto.SettlementMarketPayOrderRequestDTO;
import com.example.api.dto.SettlementMarketPayOrderResponseDTO;
import com.example.api.response.Response;

/**
 * @Author cxj
 * @Date 2025/9/9 21:30
 * @Description:
 */
public interface IMarketTradeService {

    /**
     * 营销锁单
     *
     * @param requestDTO 锁单商品信息
     * @return 锁单结果信息
     */
    Response<LockMarketPayOrderResponseDTO> lockMarketPayOrder(LockMarketPayOrderRequestDTO requestDTO);

    /**
     * 营销结算
     *
     * @param requestDTO 结算商品信息
     * @return 结算结果信息
     */
    Response<SettlementMarketPayOrderResponseDTO> settlementMarketPayOrder(SettlementMarketPayOrderRequestDTO requestDTO);


}
