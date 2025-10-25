package com.example.types.design.framework.link.model2.chain;

import com.example.types.design.framework.link.model2.handler.ILogicHandler;

/**
 * @Author cxj
 * @Date 2025/9/10 14:11
 * @Description: 受理业务流程，循环遍历责任链。
 */
public class BusinessLinkedList<T, D, R> extends LinkedList<ILogicHandler<T, D, R>> implements ILogicHandler<T, D, R> {

    public BusinessLinkedList(String name) {
        super(name);
    }

    @Override
    public R apply(T requestParameter, D dynamicContext) throws Exception {
        Node<ILogicHandler<T, D, R>> current = this.first;
        do {
            ILogicHandler<T, D, R> item = current.item;
            R apply = item.apply(requestParameter, dynamicContext);
            if (null != apply) return apply;

            current = current.next;
        } while (null != current);

        return null;
    }

}
