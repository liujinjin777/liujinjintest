package com.liujinjin.myThread.testYield;

/**
 * 优先级可以用从1到10的范围指定。10表示最高优先级，1表示最低优先级，5是普通优先级(默认)。
 *
 * 可以使用MIN_PRIORITY,MAX_PRIORITY，NORM_PRIORITY来设置优先级
 *
 * Created by liuxin on 2017/5/9.
 */
public class Main {

    public static void main(String[] args) {

        Thread thread1 = new Thread( () -> {
            for (int i = 0; i < 5; i++)
            {
                System.out.println("I am thread1 : thread1 Item " + i);
                Thread.yield();
            }
        });

        Thread thread2 = new Thread( () -> {
            for (int i = 0; i < 5; i++)
            {
                System.out.println("I am thread2 : thread2 Item " + i);
                Thread.yield();
            }
        });

        Thread thread3 = new Thread( () -> {
            for (int i = 0; i < 5; i++)
            {
                System.out.println("I am thread3 : thread3 Item " + i);
                Thread.yield();
            }
        });

        thread1.setPriority(Thread.MAX_PRIORITY);
        thread2.setPriority(Thread.MIN_PRIORITY);
        thread3.setPriority(Thread.NORM_PRIORITY);

        thread1.start();
        thread2.start();
        thread3.start();
    }

}













