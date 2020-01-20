package com.liujinjin.suanfa191229;

import org.hamcrest.Condition;
import org.junit.Test;
import org.omg.CORBA.PUBLIC_MEMBER;

import java.util.Arrays;

/**
 * 请实现一个函数，将一个字符串中的每个空格替换成“%20”。
 * 例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
 *
 * @author liuxin23
 * @date 2019/12/29
 */
public class T2 {

    @Test
    public void test(){
        StringBuffer sb = new StringBuffer();
        sb.append("We Are Happy");

        System.out.println(this.replaceSpace(sb));
    }

    public String replaceSpace(StringBuffer str) {
        if(str == null || str.length() == 0){
            return "";
        }

        int finalLength =  str.length();
        for (int i = 0 ; i < str.length() ; i++) {
            if(str.charAt(i) == ' '){
                finalLength += 2;
            }
        }

        StringBuffer newSb = new StringBuffer(finalLength);
        for (int i = 0 ; i < str.length() ; i++) {
            if(str.charAt(i) == ' '){
                newSb.append("%20");
            } else {
                newSb.append(str.charAt(i));
            }
        }

        return newSb.toString();
    }
}
