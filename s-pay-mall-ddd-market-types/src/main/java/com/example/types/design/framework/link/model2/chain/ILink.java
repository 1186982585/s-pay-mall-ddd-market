package com.example.types.design.framework.link.model2.chain;

/**
 * @Author cxj
 * @Date 2025/9/10 13:56
 * @Description:
 */
public interface ILink<E> {

    boolean add(E e);

    boolean addFirst(E e);

    boolean addLast(E e);

    boolean remove(Object o);

    E get(int index);

    void printLinkList();

}
