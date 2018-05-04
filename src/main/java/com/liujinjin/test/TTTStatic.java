package com.liujinjin.test;

/**
 * @author liuxin
 * @date 2018/3/27
 */
public class TTTStatic {

    public static final String a;

    public static final String b = calB();
    static {
        a = "1";
        System.out.println("初始化static代码块");
    }
    private static String calB() {
        System.out.println("加载static calB");
        return a + 1;
    }


}
