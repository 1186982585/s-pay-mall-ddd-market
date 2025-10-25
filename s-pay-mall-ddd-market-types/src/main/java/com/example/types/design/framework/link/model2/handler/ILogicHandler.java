package com.example.types.design.framework.link.model2.handler;

/**
 * @Author cxj
 * @Date 2025/9/10 14:12
 * @Description:
 */
public interface ILogicHandler<T, D, R> {

    default R next(T requestParameter, D dynamicContext) {
        return null;
    }

    R apply(T requestParameter, D dynamicContext) throws Exception;

}
