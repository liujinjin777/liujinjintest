package com.liujinjin;

/**
 * @author liuxin
 * @date 2018/12/2
 */
public class ThreadGate{
    private boolean isOpen = false;
    // private int count = 0;

    public synchronized void close () {
        isOpen = false;
        // count++;
    }

    public synchronized void open(){
        isOpen = true;
        notifyAll();
    }

    public synchronized void await() throws InterruptedException {
        while (!isOpen) {
            System.out.println(Thread.currentThread().getName() + "wait 10s");
            this.wait(10000L);
        }

          /*
          int localCount = count;
          while (!isOpen && localCount == count ) {
          	wait();
          }
          */
    }

    public static void main(String[] arg){
        ThreadGate gate = new ThreadGate();
        new Thread(){
            @Override
            public void run(){
                try {
                    gate.await();
                    System.out.println(Thread.currentThread().getName() + " dosmetion");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                // todo something
            }
        }.start();

        new Thread(){
            @Override
            public void run(){
                try {
                    gate.await();
                    System.out.println(Thread.currentThread().getName() + " dosmetion");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                // todo something
            }
        }.start();

        gate.open();
        System.out.println("dakai");

        // 特殊情况
        // gate.open();
        // gate.close();
    }

}


