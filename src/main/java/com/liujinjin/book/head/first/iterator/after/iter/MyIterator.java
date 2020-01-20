package com.liujinjin.book.head.first.iterator.after.iter;

/**
 * @author liuxin
 * @date 2018/6/27
 */
public interface MyIterator {

    /**
     * 是否有下一个元素
     * @return
     */
    boolean hasNext();

    /**
     * 获取下一个元素
     * @return
     */
    Object next();
}
