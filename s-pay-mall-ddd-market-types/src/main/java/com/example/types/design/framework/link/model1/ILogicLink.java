package com.example.types.design.framework.link.model1;

/**
 * @Author cxj
 * @Date 2025/9/10 13:31
 * @Description: 并提供一个受理业务逻辑的方法。
 */
public interface ILogicLink<T, D, R> extends ILogicChainArmory<T, D, R> {

    R apply(T requestParameter, D dynamicContext) throws Exception;

}
