package com.ly.concurrent;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Author: liyan
 * @Description: 实现Runnable接口的线程
 * @Date: Created in 14:30 2018/8/9
 * @Modified By:
 */
public class MyRunnable{
    private static final Logger LOGGER = LoggerFactory.getLogger(MyRunnable.class);

    public static void main(String[] args){
        for (int i=0;i<20;i++) {
            Runnable runnable = new Runnable() {
                @Override
                public void run() {
                    System.out.println("开启一个实现Runnable接口的线程");
                }
            };
            Thread thread = new Thread(runnable);
            thread.start();
            System.out.println("Thread name: " + thread.getName());
        }
    }
}
