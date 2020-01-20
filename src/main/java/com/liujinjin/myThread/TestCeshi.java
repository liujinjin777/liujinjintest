package com.liujinjin.myThread;

import org.junit.Test;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @author liuxin
 * @date 2019/5/23
 */
public class TestCeshi {

    private volatile boolean flag = false;

    private volatile CyclicBarrier barrier = new CyclicBarrier(3);

    @Test
    public void test() throws BrokenBarrierException, InterruptedException {

        for (int i = 0; i < 3; i++) {


        Thread thread1 = new Thread(() -> {

                try {
                    System.out.println("a-" + System.currentTimeMillis());
                    barrier.await();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                System.out.println("a-" + Thread.currentThread().getName());


        });

        Thread thread2 = new Thread(() -> {
            try {
                Thread.sleep(2000L);
                System.out.println("b-" + System.currentTimeMillis());
                barrier.await();
            } catch (Exception e) {
                e.printStackTrace();
            }

            System.out.println("b-" + Thread.currentThread().getName());

        });

        thread1.start();
        thread2.start();

        System.out.println("main-" + System.currentTimeMillis());
        barrier.await();


        System.out.println("------------------");
        }
    }

}
