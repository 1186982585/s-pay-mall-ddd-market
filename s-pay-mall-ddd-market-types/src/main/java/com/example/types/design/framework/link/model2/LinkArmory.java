package com.example.types.design.framework.link.model2;

import com.example.types.design.framework.link.model2.chain.BusinessLinkedList;
import com.example.types.design.framework.link.model2.handler.ILogicHandler;

/**
 * @Author cxj
 * @Date 2025/9/10 14:14
 * @Description: 链路装配
 */
public class LinkArmory<T, D, R> {

    private final BusinessLinkedList<T, D, R> logicLink;

    @SafeVarargs
    public LinkArmory(String linkName, ILogicHandler<T, D, R>... logicHandlers) {
        logicLink = new BusinessLinkedList<>(linkName);
        for (ILogicHandler<T, D, R> logicHandler: logicHandlers){
            logicLink.add(logicHandler);
        }
    }

    public BusinessLinkedList<T, D, R> getLogicLink() {
        return logicLink;
    }

}
