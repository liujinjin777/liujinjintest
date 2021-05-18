package com.liujinjin.suanfa20210506.str;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

/**
 * @author liuxin14 <liuxin14@kuaishou.com>
 * Created on 2021-05-11
 */
public class T763 {

    @Test
    public void test() {
        String s = "ababcbacadefegdehijhklij";
        System.out.println(partitionLabels(s));
    }

    public List<Integer> partitionLabels(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), i);
        }
        List<Integer> list = new ArrayList<>();
        int i = 0;
        while (i < s.length()) {
            char c = s.charAt(i);
            // c的最大角标值
            int ci = map.get(c);
            int j = i + 1;
            while (j < ci) {
                if (s.charAt(j) == c) {
                    continue;
                }
                ci = Math.max(ci, map.get(s.charAt(j)));
                j++;
            }
            list.add(ci - i + 1);
            i = ci + 1;
        }

        return list;
    }
}
