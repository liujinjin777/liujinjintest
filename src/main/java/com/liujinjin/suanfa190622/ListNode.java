package com.liujinjin.suanfa190622;

/**
 * @author liuxin
 * @date 2019/6/23
 */
public class ListNode {
    public Integer val;
    public ListNode next;

    public ListNode(int x, ListNode next) {
        this.val = x;
        this.next = next;
    }
    public ListNode(int x) {
        this.val = x;
    }
    public ListNode() {
    }


    @Override
    public String toString() {
        return "ListNode{" +
                "val=" + val +
                ", next=" + next +
                '}';
    }
}
