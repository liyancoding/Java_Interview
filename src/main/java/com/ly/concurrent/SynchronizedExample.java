package com.ly.concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static java.lang.Thread.sleep;

/**
 * @Author: liyan
 * @Description: Synchronized
 * @Date: Created in 15:13 2018/8/10
 * @Modified By:
 */
public class SynchronizedExample {

    /**
     * synchronized修饰代码块
     */
    public void func1() {
        synchronized (this) {
            for (int i = 0; i < 150; i++) {
                System.out.print(i + " ");

            }
        }
    }

    /**
     * synchronized修饰方法
     */
    public synchronized void func2() {
        for(int i=0;i<150;i++) {
            System.out.print(i + " ");
        }
    }

    /**
     * synchronized修饰静态方法
     */
    public synchronized static void func3() {
        for(int i=0;i<150;i++) {
            System.out.print(i + " ");
        }
    }

    /**
     * synchronized修饰类
     */
    public void func4() {
        synchronized (SynchronizedExample.class) {
            for(int i=0;i<150;i++) {
                System.out.print(i + " ");
            }
        }
    }

}
