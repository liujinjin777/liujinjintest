package com.liujinjin.suanfa.array;

import com.liujinjin.suanfa.common.Node;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by liuxin on 17/3/24.
 */
public class ArrayAndLinkedList {

    private int num = 100 * 10000;

    public static void main(String[] args) {
        ArrayAndLinkedList arrayAndLinkedList = new ArrayAndLinkedList();
        //arrayAndLinkedList.addArray();
        //arrayAndLinkedList.addLinked();
        arrayAndLinkedList.addArrayObj();
    }

    // 100,0000=44ms    1000,0000=4597ms    5*1000,0000=20130ms
    public void addArray(){
        List<Integer> arrayList = new ArrayList<Integer>();
        long currentTime = System.currentTimeMillis();
        for(int i = 0; i<num ; i++){
            arrayList.add(i);
        }
        System.out.println("array use time=" +(System.currentTimeMillis() - currentTime) +"ms");
    }

    // 100,0000=391ms    1000,0000=14299ms    5*1000,0000=Exception in thread "main" java.lang.OutOfMemoryError: Java heap space
    public void addArrayObj(){
        List<Node> arrayList = new ArrayList<Node>();
        long currentTime = System.currentTimeMillis();
        for(int i = 0; i<num ; i++){
            Node node = new Node();
            node.value = i;
            arrayList.add(node);
        }
        System.out.println("array add NODE use time=" +(System.currentTimeMillis() - currentTime) +"ms");
    }

    // 100,0000=166ms   1000,0000=9501ms    5*1000,0000=java.lang.OutOfMemoryError: GC overhead limit exceeded
    public void addLinked(){
        List<Integer> linkedList = new LinkedList<Integer>();
        long currentTime = System.currentTimeMillis();
        for(int i = 0; i<num ; i++){
            linkedList.add(i);
        }
        System.out.println("linked use time=" +(System.currentTimeMillis() - currentTime) +"ms");
    }
}
