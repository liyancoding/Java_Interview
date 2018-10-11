package com.ly.futureConcurrent;

import ch.qos.logback.core.util.TimeUtil;

import java.util.concurrent.TimeUnit;

/**
 * @Author: liyan
 * @Description:
 * @Date: Created in 10:48 2018/8/20
 * @Modified By:
 */
public class InterruptedExample {

    public static void main(String[] args) throws InterruptedException {
        Thread sleepThread = new Thread(new SleepThread(), "sleepThread");
        sleepThread.setDaemon(true);

        Thread busyThread = new Thread(new BusyThread(), "busyThread");
        busyThread.setDaemon(true);

        sleepThread.start();
        busyThread.start();

        TimeUnit.SECONDS.sleep(5);

//        sleepThread.suspend();
//        sleepThread.resume();
//        sleepThread.stop();

        sleepThread.interrupt();
        busyThread.interrupt();

        System.out.println("sleepThread interrupted is " + sleepThread.isInterrupted());
        System.out.println("busyThread interrupted is " + busyThread.isInterrupted());

        TimeUnit.SECONDS.sleep(2);
    }

    private static class SleepThread implements Runnable {

        @Override
        public void run() {
            while (true) {
                SleepUtils.second(20);
            }
        }
    }

    private static class BusyThread implements Runnable {

        @Override
        public void run() {
            while (true) {
                
            }
        }
    }
}
