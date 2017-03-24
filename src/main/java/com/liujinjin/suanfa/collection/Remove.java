package com.liujinjin.suanfa.collection;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by liuxin on 17/2/10.
 */
public class Remove {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<Integer>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(2);
        list.add(2);
        list.add(2);

        for(int i = 0; i<list.size(); i++){
            list.remove(i);
        }

        System.out.println(list);
    }


}
