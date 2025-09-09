package com.example.domain.trade.model.valobj;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author cxj
 * @Date 2025/9/9 20:48
 * @Description:
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class GroupBuyProgressVO {

    private Integer targetCount;
    private Integer completeCount;
    private Integer lockCount;

}
