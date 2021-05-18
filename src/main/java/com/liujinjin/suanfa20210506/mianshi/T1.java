package com.liujinjin.suanfa20210506.mianshi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;


/**
 * {1, -1, 0, 1, -1}
 *
 * @author liuxin14 <liuxin14@kuaishou.com>
 * Created on 2021-05-08
 */
public class T1 {

    @Test
    public void test() {
        int[] array = {1, -1, 0, 1, -1};
        System.out.println(sum(array));
    }

    public List<List<Integer>> sum(int[] array) {
        if (array == null || array.length < 3) {
            return Collections.emptyList();
        }
        // Arrays.sort();
        // key=值 value=角标
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < array.length; i++) {
            map.put(array[i], i);
        }

        List<List<Integer>> list = new ArrayList<>();
        // {1, -1, 0, 1, -1}
        for (int i = 0; i < array.length - 1; i++) {
            int x = array[i];
            for (int j = i + 1; j < array.length; j++) {
                if (i == j) {
                    continue;
                }
                int y = array[j];
                int z = -x - y;
                // z的数组角标
                Integer z2 = map.get(z);
                if (z2 != null && z2 > i && z2 > j) {
                    List<Integer> temp = new ArrayList<>(3);
                    temp.add(i);
                    temp.add(j);
                    temp.add(z2);
                    list.add(temp);
                }
            }
        }

        return list;
    }

}








