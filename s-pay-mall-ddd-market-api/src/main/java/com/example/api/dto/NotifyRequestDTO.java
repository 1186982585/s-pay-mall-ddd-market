package com.example.api.dto;

import lombok.Data;

import java.util.List;

/**
 * @Author cxj
 * @Date 2025/11/20 20:26
 * @Description: 回调请求对象
 */
@Data
public class NotifyRequestDTO {

    /** 组队ID */
    private String teamId;
    /** 外部单号 */
    private List<String> outTradeNoList;

}
