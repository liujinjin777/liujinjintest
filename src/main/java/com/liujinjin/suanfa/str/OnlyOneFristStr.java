package com.liujinjin.suanfa.str;

/**
 * 查找出第一次出现一个的字符
 *
 * Created by liuxin on 17/1/25.
 */
public class OnlyOneFristStr {

    public static void main(String[] args) {
        String str = "ss";
        System.out.println(OnlyOneFristStr.getOnlyOneFristStr(str));
    }

    /**
     * 查找出第一次出现一个的字符
     *
     * @param str  例如: asd123sdwer2423sdsd
     * @return     返回: 1
     */
    public static String getOnlyOneFristStr(String str){
        if(str == null || "".equals(str.trim()) ) return null;

        char[] chars = str.toCharArray();
        int[] charArray = new int[256];
        for(char c : chars){
            charArray[(int)c]++;
        }
        for(char c : chars){
            if(charArray[(int)c] == 1){
                return String.valueOf(c);
            }
        }

        return null;
    }


}
















