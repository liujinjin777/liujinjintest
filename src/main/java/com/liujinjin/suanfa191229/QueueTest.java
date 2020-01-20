package com.liujinjin.suanfa191229;

import org.junit.Test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author liuxin23
 * @date 2020/01/11
 */
public class QueueTest {

    @Test
    public void test(){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        System.out.println(queue);
        queue.add(2);
        System.out.println(queue);

        queue.offer(3);
        System.out.println(queue);

        Integer peek = queue.peek();
        System.out.println(peek + "  " +queue);

        Integer poll = queue.poll();
        System.out.println(poll + "  " +queue);

        // 与peek区别是，会抛出异常 NoSuchElementException if this queue is empty
        Integer element = queue.element();
        System.out.println(element + "  " +queue);


    }
}
