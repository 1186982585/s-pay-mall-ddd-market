package com.example.types.design.framework.tree;

/**
 * @Author cxj
 * @Date 2025/5/22 15:15
 * @Description: 策略处理器
 */
public interface StrategyHandler<T, D, R> {

    StrategyHandler DEFAULT = (T, D) -> null;

    R apply(T requestParameter, D dynamicContext) throws Exception;


}
