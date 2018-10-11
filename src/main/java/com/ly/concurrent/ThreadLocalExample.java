package com.ly.concurrent;

/**
 * @Author: liyan
 * @Description:
 * @Date: Created in 21:34 2018/8/14
 * @Modified By:
 */
public class ThreadLocalExample {
    public static void main(String[] args){

//        ThreadLocal threadLocal = new ThreadLocal();
//
//        Thread thread = new Thread(()->{
//            threadLocal.set(1);
//
//            try {
//                Thread.sleep(2000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//
//            System.out.println("thread: " + threadLocal.get());
//
//            threadLocal.remove();
//        });
//
//        Thread thread1 = new Thread(()->{
//            threadLocal.set(2);
//
//            System.out.println("thread1: " + threadLocal.get());
//
//            threadLocal.remove();
//        });
//
//        thread.start();
//
//        thread1.start();

        ThreadLocal threadLocal = new ThreadLocal();
        ThreadLocal threadLoca2 = new ThreadLocal();

        Thread thread1 = new Thread(()->{
            threadLocal.set(1);
            threadLoca2.set(5);

            System.out.println("thread1: " + threadLocal.get() + " 、" + threadLoca2.get());

            threadLocal.remove();
            threadLoca2.remove();
        });

        Thread thread2 = new Thread(() -> {
            threadLocal.set(8);
            threadLoca2.set(25);

            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("thread2: " + threadLocal.get() + " 、" + threadLoca2.get());

            threadLocal.remove();
            threadLoca2.remove();
        });

        thread1.start();
        thread2.start();
    }
}
