package com.liujinjin.book.GoodCoding.Advice6;

/**
 * Created by liuxin on 17/3/17.
 */
public class T1 {

    public static void main(String[] args) {
        int x = 4;
        StringBuffer sb = new StringBuffer("..fedcba");
        sb.delete(3,6);
        sb.insert(3, "az");
        if(sb.length() > 6){
            x = sb.indexOf("b");
        }
        sb.delete(x-3, x-2);
        System.out.println(sb);
    }
}
