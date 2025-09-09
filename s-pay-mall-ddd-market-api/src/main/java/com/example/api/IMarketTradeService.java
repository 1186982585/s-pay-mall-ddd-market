package com.example.api;

import com.example.api.dto.LockMarketPayOrderRequestDTO;
import com.example.api.dto.LockMarketPayOrderResponseDTO;
import com.example.api.response.Response;

/**
 * @Author cxj
 * @Date 2025/9/9 21:30
 * @Description:
 */
public interface IMarketTradeService {

    Response<LockMarketPayOrderResponseDTO> lockMarketPayOrder(LockMarketPayOrderRequestDTO lockMarketPayOrderRequestDTO);

}
