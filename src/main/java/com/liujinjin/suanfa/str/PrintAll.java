package com.liujinjin.suanfa.str;

/**
 * Created by liuxin on 17/2/28.
 */
public class PrintAll {

    public static void main(String[] args) {
        String s = "abc";

        listAll(s, "");
    }


    public static void listAll(String str, String prefix){
        if(3 == prefix.length())
            System.out.println(prefix);

        char[] chars = str.toCharArray();
        for(int i=0; i< chars.length; i++){
            listAll(str.substring(0,i) + str.substring(i+1, str.length()), prefix+String.valueOf(chars[i]));
        }
    }

}
