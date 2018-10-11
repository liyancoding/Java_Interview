package com.ly.futureConcurrent;

import java.sql.Time;

/**
 * @Author: liyan
 * @Description:
 * @Date: Created in 14:50 2018/8/20
 * @Modified By:
 */
public class JoinExample {

    MyThread myThread1 = new MyThread("myThread1",10);
    MyThread myThread2 = new MyThread("myThread2", 10);

    Thread t1 = new Thread(myThread1);
    Thread t2 = new Thread(myThread2);

    private static class MyThread implements Runnable {


        private String threadName;

        private long times;

        MyThread(String threadName, long times) {
            this.threadName = threadName;
            this.times = times;
        }

        @Override
        public void run() {
            for (int i=0;i<times;i++) {
                System.out.println(threadName + "----->" + i);
            }
        }
    }

}
