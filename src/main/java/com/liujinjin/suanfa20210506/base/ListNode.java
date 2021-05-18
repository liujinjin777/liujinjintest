package com.liujinjin.suanfa20210506.base;

/**
 * @author liuxin14 <liuxin14@kuaishou.com>
 * Created on 2021-05-07
 */
public class ListNode {
    public int val;
    public ListNode next;

    public ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    @Override
    public String toString() {
        return "val=" + val + ", next=" + next;
    }
}
