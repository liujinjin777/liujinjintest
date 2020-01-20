package com.liujinjin.test;

import java.util.concurrent.locks.AbstractQueuedSynchronizer;

/**
 * @author liuxin
 * @date 2018/12/11
 */
public class MyLock {

    private final Sync sync = new Sync();

    public void lock() {
        sync.acquire(1);
    }

    public void unlock() {
        sync.release(1);
    }

    public boolean isLocked() {
        return sync.isHeldExclusively();
    }


    private static class Sync extends AbstractQueuedSynchronizer {
        @Override
        protected boolean tryAcquire(int arg) {

            //首先判断状态是否等于=0,如果状态==0，就将status设置为1
            if (compareAndSetState(0, 1)) {
                //将当前线程赋值给独占模式的onwer
                setExclusiveOwnerThread(Thread.currentThread());
                return true;
            }

            return false;

        }

        @Override
        protected boolean tryRelease(int arg) {
            if (getState() == 0) {
                throw new IllegalMonitorStateException();
            }
            setExclusiveOwnerThread(null);
            setState(0);
            return true;
        }

        @Override
        protected boolean isHeldExclusively() {
            return getState() == 1;
        }
    }


    public static void main(String[] args) throws InterruptedException {
        MyLock myLock = new MyLock();

        Thread thread1 = new Thread() {
            @Override
            public void run() {
                myLock.lock();
                myLock.unlock();
            }
        };

        thread1.setName("thread1");
        thread1.start();

        Thread.sleep(3000L);
        Thread thread2 = new Thread() {
            @Override
            public void run() {
                myLock.lock();
            }
        };

        thread2.setName("thread2");
        thread2.start();


    }

}
