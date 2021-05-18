package com.liujinjin.suanfa20210506.node;

import org.junit.Test;

/**
 * @author liuxin14 <liuxin14@kuaishou.com>
 * Created on 2021-05-13
 */
public class T5 {

    @Test
    public void test() {
        System.out.println(longestPalindrome("babad"));
        //System.out.println(palind(2, 2, "babad"));
    }

    public String longestPalindrome(String s) {
        if (s == null) {
            return null;
        }

        int start = 0;
        int end = 0;

        for (int i = 1; i < s.length(); i++) {
            // 奇数
            int l1 = palind(i, i, s);
            // 偶数
            int l2 = palind(i, i + 1, s);
            int max = Math.max(l1, l2);

            if (max > (end - start + 1)) {
                start = i - (max - 1) / 2;
                end = max / 2 + i;
            }
        }

        return s.substring(start, end + 1);
    }

    private int palind(int left, int right, String s) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return right - left - 1;
    }

}
