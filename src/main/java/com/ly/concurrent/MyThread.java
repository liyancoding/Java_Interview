package com.ly.concurrent;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Author: liyan
 * @Description:
 * @Date: Created in 14:51 2018/8/9
 * @Modified By:
 */
public class MyThread extends Thread{
    private static final Logger LOGGER = LoggerFactory.getLogger(MyThread.class);

    public void run() {
        for(int i=0;i<10;i++) {
//            Thread.yield();
            System.out.println("开启一个继承Thread类的线程" + i);
        }
//        System.out.println("开启一个继承Thread类的线程");
    }

    public static void main(String[] args) throws InterruptedException {
        MyThread my = new MyThread();

//        my.setDaemon(true); // 将my设置为守护线程

//        Thread.sleep(3000); // 休眠3秒后执行

        Boolean b = my.isInterrupted();
        System.out.println("b = " + b); // false

        my.start();

//        Thread.sleep(5000); // 让当前正在执行的线程休眠5秒

        System.out.println("Thread name: " + my.getName());
    }

//    public static void main(String[] args){
//        Thread th = new Thread(){
//            @Override
//            public void run() {
//                System.out.println("开启一个继承Thread类的线程");
//            }
//        };
//        th.start();
//    }
}
