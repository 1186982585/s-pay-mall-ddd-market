package com.example.types.design.framework.tree;

/**
 * @Author cxj
 * @Date 2025/5/22 15:14
 * @Description: 策略映射器
 */
public interface StrategyMapper<T, D, R> {

    /**
     * 获取待执行策略
     *
     * @param requestParameter 入参
     * @param dynamicContext   上下文
     * @return 返参
     * @throws Exception 异常
     */
    StrategyHandler<T, D, R> get(T requestParameter, D dynamicContext) throws Exception;

}
