package com.liujinjin.suanfa.lianbiao;

import com.liujinjin.suanfa.common.Node;

/**
 * Created by liuxin on 17/1/19.
 */
public class Run {

    public static void main(String[] args) {
        Node node = new Node(1, new Node(2,
                new Node(3, new Node(
                        4, new Node(5)
                )))
        );

        System.out.println(node);
        System.out.println(new T1().reverNode(node));
    }
}
