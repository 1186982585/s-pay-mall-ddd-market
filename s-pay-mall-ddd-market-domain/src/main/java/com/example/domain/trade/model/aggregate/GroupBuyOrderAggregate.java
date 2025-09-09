package com.example.domain.trade.model.aggregate;

import com.example.domain.trade.model.entity.PayActivityEntity;
import com.example.domain.trade.model.entity.PayDiscountEntity;
import com.example.domain.trade.model.entity.UserEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author cxj
 * @Date 2025/9/9 20:46
 * @Description:
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class GroupBuyOrderAggregate {

    private UserEntity userEntity;

    private PayActivityEntity payActivityEntity;

    private PayDiscountEntity payDiscountEntity;

}
