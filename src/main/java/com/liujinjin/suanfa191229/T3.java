package com.liujinjin.suanfa191229;

import com.liujinjin.suanfa190622.ListNode;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author liuxin23
 * @date 2019/12/29
 */
public class T3 {

    @Test
    public void test(){
        ListNode l1 = new ListNode(2, new ListNode(3, new ListNode(4, null)));
        System.out.println(this.printListFromTailToHead(l1));
    }

    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {

        ArrayList<Integer> list = new ArrayList<>();
        this.add(list, listNode);
        return list;
    }

    private void add(ArrayList<Integer> list, ListNode listNode) {
        if (listNode != null){
            this.add(list, listNode.next);
            list.add(listNode.val);
        }

    }
}
