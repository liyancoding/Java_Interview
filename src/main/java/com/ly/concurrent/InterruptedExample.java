package com.ly.concurrent;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @Author: liyan
 * @Description:
 * @Date: Created in 13:59 2018/8/10
 * @Modified By:
 */
public class InterruptedExample {
    private static final Logger LOGGER = LoggerFactory.getLogger(InterruptedExample.class);

    public static class MyThread1 extends Thread {
        @Override
        public void run() {
            try {
                Thread.sleep(2000);
                LOGGER.info("Thread run");
            } catch (InterruptedException e) {
//                LOGGER.error(e.getMessage());
                e.printStackTrace();
            }
        }
    }

    public static class MyThread2 extends Thread{
        @Override
        public void run() {
            while (interrupted()) {

            }
            LOGGER.info("Thread end");
        }
    }

    /**
     * 在main()中启动一个线程，然后在中断，由于run()方法中调用了sleep()方法，所以会抛出InterruptedException异常，
     * 从而提前结束线程，不执行后面的语句。
     * @param args
     */
    public static void main(String[] args){

//        MyThread1 th1 = new MyThread1();
//
//        th1.start();
//
//        System.out.println(th1.isInterrupted());
//
//
//        LOGGER.info("Main run");


        // 使用Lambda创建线程，相当于创建了一个匿名内部线程。类似于F#函数。
        ExecutorService ex = Executors.newCachedThreadPool();
        ex.execute(() -> {
            try {
                Thread.sleep(3000);
                LOGGER.info("Thread run");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        // 中断Executor每一个线程
        ex.shutdownNow();

        // 若是想中断Executor中的一个线程，通过submit()提交一个线程，它返回一个Future<?>对象，
        // 通过调用这个对象的cancel(true)方法就可以中断这个线程。
//        Future<?> future = ex.submit(()->{
//            //
//        });
//        future.cancel(true);

        LOGGER.info("Main run");
    }
}
