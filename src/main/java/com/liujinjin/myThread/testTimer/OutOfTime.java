package com.liujinjin.myThread.testTimer;

import java.util.Timer;
import java.util.TimerTask;

import static java.util.concurrent.TimeUnit.SECONDS;

/**
 * Created by liuxin on 2017/7/21.
 */
public class OutOfTime {

    public static void main(String[] args) throws Exception {
        long start = System.currentTimeMillis();

        try {
            Timer timer = new Timer();
            timer.schedule(new ThrowTask(), 1);
            SECONDS.sleep(1);

            timer.schedule(new ThrowTask(), 1);
            SECONDS.sleep(5);
        }catch (Exception ignored){

        }

        System.out.println(System.currentTimeMillis() - start);
    }

    static class ThrowTask extends TimerTask {
        @Override
        public void run() {
            throw new RuntimeException();
        }
    }

}
