package com.liujinjin.util;

import java.util.concurrent.atomic.AtomicReference;

/**
 * @author liuxin
 * @date 2018/12/21
 */
public class NoBlockSycnLinked {

    private Node sentry = new Node(null, null);
    private AtomicReference<Node> head = new AtomicReference(sentry);
    private AtomicReference<Node> atomicTail = new AtomicReference(sentry);

    public void put (Object value) {
        Node newNode = new Node(value, null);
        AtomicReference newNodeAtomic = new AtomicReference(newNode);

        Node tail = atomicTail.get();
        AtomicReference<Node> tailNext = tail.getNext();
        if(tailNext == null){
            // 正常替换
            tail.setNext(newNodeAtomic);
            atomicTail.compareAndSet(tail, newNode);
        } else {
            // 处于非稳定状态
            atomicTail.compareAndSet(tail, tailNext.get());
        }

    }

}
