package com.liujinjin.suanfa20210506.mianshi;

import java.util.HashSet;
import java.util.Set;

import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

/**
 * 最长不重复子串
 *
 * @author liuxin14 <liuxin14@kuaishou.com>
 * Created on 2021-05-08
 */
public class T3 {

    @Test
    public void test() {
        System.out.println(get("babcdabab"));
    }

    private String get(String s) {
        if (StringUtils.isBlank(s) || s.length() == 1) {
            return s;
        }

        char[] c = s.toCharArray();
        Set<Character> set = new HashSet<>();
        // babcdabab
        int start = 0;
        int end = 0;

        for (int i = 0; i < c.length - 1; i++) {
            set.add(c[i]);
            int tempEnd = 0;
            for (int j = i + 1; j < c.length; j++) {
                char cha = c[j];
                if (set.contains(cha)) {
                    break;
                }
                set.add(c[i]);
                tempEnd = j;
            }
            // 当有更长的字符串
            if ((end - start) < (tempEnd - i)) {
                start = i;
                end = tempEnd;
            }
        }

        StringBuilder res = new StringBuilder();
        for (int i = start; i <= end; i++) {
            res.append(c[i]);
        }

        return res.toString();
    }
}
