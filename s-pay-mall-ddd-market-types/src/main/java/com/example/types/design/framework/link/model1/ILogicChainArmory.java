package com.example.types.design.framework.link.model1;

/**
 * @Author cxj
 * @Date 2025/9/10 13:32
 * @Description: 装配链，提供添加节点方法和获取节点。
 */
public interface ILogicChainArmory<T, D, R>{

    ILogicLink<T, D, R> next();

    ILogicLink<T, D, R> appendNext(ILogicLink<T, D, R> next);

}
