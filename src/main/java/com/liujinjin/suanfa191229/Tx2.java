package com.liujinjin.suanfa191229;

import com.liujinjin.suanfa190622.ListNode;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.TreeSet;

/**
 * @author liuxin23
 * @date 2020/01/12
 */
public class Tx2 {

    @Test
    public void test(){
        int[] a = {1,3,0,7,0};
        System.out.println(this.LastRemaining_Solution(5,3));
    }


    public int LastRemaining_Solution(int n, int m) {
        if(n < 2 || m < 1){
            return n;
        }

        Node node = new Node();
        node.val = 0;
        Node head = node;
        for (int i = 1; i < n; i++) {
            node.next = new Node();
            node = node.next;
            node.val = i;
        }
        node.next = head;

        Node pre = head;
        int temp = m;
        while (true) {
            if(temp == 1){
                if(pre.next.equals(head.next)){
                    break;
                }
                pre.next = head.next;
                temp = m;
            } else {
                pre = head;
                temp--;
            }
            head = head.next;
        }

        return head.next.val;

    }

    public class Node{
        public int val;
        public Node next;
    }
}
