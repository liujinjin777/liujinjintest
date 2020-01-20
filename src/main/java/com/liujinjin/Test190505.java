package com.liujinjin;

import org.junit.Test;

/**
 * @author liuxin
 * @date 2019/5/5
 */
public class Test190505 {

    Object obj = new Object();



    @Test
    public void test2(){
        try {
            System.out.println(2/0);
        } catch (Exception e){
            MyException myException = new MyException();
            myException.initCause(e);
           // myException.initCause(myException);
            throw myException;

        }
    }



    @Test
    public void test() throws InterruptedException {
        Thread thread = new Thread(() -> {
            try {
                System.out.println("wait start");
                //obj.wait();
                Thread.sleep(1000);

                System.out.println("wait end");
            } catch (Exception e) {
                System.out.println(e);
            }
            System.out.println(111);
        });

        thread.start();

        thread.interrupt();
        Thread.interrupted();
        thread.isInterrupted();



        Thread.sleep(10000);
    }

}
