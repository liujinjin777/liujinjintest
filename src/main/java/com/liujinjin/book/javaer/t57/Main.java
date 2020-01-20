package com.liujinjin.book.javaer.t57;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by liuxin on 2017/8/22.
 */
public class Main {

    public static void main(String[] args) {

        String s = "hi is me";

        Pattern parttern = Pattern.compile("\\b\\w+\\b");
        Matcher matcher = parttern.matcher(s);
        int sum = 0;
        while(matcher.find()){
            sum++;
        }

        System.out.println(s + ",sum :" + sum);
    }
}
