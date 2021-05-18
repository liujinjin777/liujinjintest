package com.liujinjin.suanfa20210506.jav;

/**
 * 双重校验单例
 * @author liuxin14 <liuxin14@kuaishou.com>
 * Created on 2021-05-06
 */
public class Single {

    private static volatile Single s;

    private Single() {
    }

    public static Single get() {
        if (s != null) {
            return s;
        }
        synchronized (Single.class) {
            if (s == null) {
                s = new Single();
            }
        }
        return s;
    }

    public void sys(){
        System.out.println(1111);
    }
}
