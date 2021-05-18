package com.liujinjin.suanfa20210506.node;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.junit.Test;

/**
 * @author liuxin14 <liuxin14@kuaishou.com>
 * Created on 2021-05-09
 */
public class T3 {

    @Test
    public void test() {
        String s = "abcabcbb";
        System.out.println(lengthOfLongestSubstring(s));
    }

    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        // key=字符 value=角标
        Map<Character, Integer> map = new HashMap<>();
        Map<Character, Integer> firstMap = new HashMap<>();
        int left = 0;
        int max = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            Integer point = map.get(c);
            if (point != null && point >= left) {
                left = point + 1;
                map.remove(c);
            }
            map.put(c, i);

            int tempMax = i - left + 1;
            if (tempMax > max) {
                max = tempMax;
                firstMap.putAll(map);
            }
        }
        List<Integer> sortValues = firstMap.values().stream().sorted().collect(Collectors.toList());
        for (Integer i : sortValues) {
            System.out.println(s.charAt(i));
        }
        return max;
    }
}
