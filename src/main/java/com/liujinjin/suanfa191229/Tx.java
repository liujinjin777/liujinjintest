package com.liujinjin.suanfa191229;

import com.liujinjin.suanfa190622.ListNode;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author liuxin23
 * @date 2020/01/05
 */
public class Tx {

    @Test
    public void test(){
        String a = "123";


        String substring = a.substring(1, 3);
        System.out.println(substring);

        RandomListNode t1 = new RandomListNode(1);
        RandomListNode t2 = new RandomListNode(2);
        RandomListNode t3 = new RandomListNode(3);
        RandomListNode t4 = new RandomListNode(4);
        RandomListNode t5 = new RandomListNode(5);
        RandomListNode t6 = new RandomListNode(6);
        t1.next = t2;
        t1.random = t4;
        t2.next = t3;
        t3.next = t4;
        t4.next = t5;
        t5.next = t6;
        t6.random = t1;

        RandomListNode clone = this.Clone(t1);
        System.out.println(clone);
    }
    public class RandomListNode {
        int label;
        RandomListNode next = null;
        RandomListNode random = null;

        RandomListNode(int label) {
            this.label = label;
        }

        @Override
        public String toString() {
            return "RandomListNode{" +
                    "label=" + label +
                    ", random=" + (random != null ? random.label : 0) +
                    ", next=" + next +
                    '}';
        }
    }



    public RandomListNode Clone(RandomListNode pHead){
        if(pHead == null){
            return null;
        }

        if(pHead.next == null){
            return this.copy(pHead);
        }

        RandomListNode  pointNode = pHead;
        while (pointNode != null){
            RandomListNode node = this.copy(pointNode);
            RandomListNode tempNext = node.next;
            pointNode.next = node;
            node.next = tempNext;
            // 往下遍历
            pointNode = tempNext;
        }

        RandomListNode result = pHead.next;
        while(pHead.next.next != null){
            RandomListNode copyNode = pHead.next;
            // 设置random节点
            if(pHead.random != null){
                copyNode.random = pHead.random.next;
            }

            RandomListNode tempNextNext = copyNode.next;
            copyNode.next = copyNode.next.next;
            pHead = tempNextNext;
        }

        return result;

    }

    private RandomListNode copy (RandomListNode node){
        RandomListNode copy = new RandomListNode(node.label);
        copy.next = node.next;
        copy.random = node.random;
        return copy;
    }
}
