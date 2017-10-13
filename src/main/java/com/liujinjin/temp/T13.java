package com.liujinjin.temp;

/**
 * Created by liuxin on 2017/9/23.
 *
 * 找出第一次出现一次的字符
 *
 * a a b b c
 * abcasdasd
 */
public class T13 {

    public static void main(String[] args) {

        String str = "abcdea";
        if(str == null){
            return;
        }

        char[] characters = str.toCharArray();

        int[] array = new int[255];
        for(Character c : characters){
            array[c]++;
        }

        for(Character c : characters){
            if(array[c] == 1){
                System.out.println(c);
                break;
            }
        }

        char c='a';
        int i=98;
        System.out.println((int)c);
        System.out.println((char)i);

    }
}
