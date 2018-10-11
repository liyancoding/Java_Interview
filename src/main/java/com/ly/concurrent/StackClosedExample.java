package com.ly.concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Author: liyan
 * @Description:
 * @Date: Created in 21:07 2018/8/14
 * @Modified By:
 */
public class StackClosedExample {

    // i为全局变量，线程不安全
//    static int i = 0;

    public static void add() {

        // i为局部变量，存储在栈中，栈是线程私有的，是封闭的，所以是线程安全的，不需要同步。
        int i = 0;

        for (int k=0;k<100;k++) {
            i += k;
        }
        System.out.println(i);
    }
    
    public static void main(String[] args){


        ExecutorService ex = Executors.newCachedThreadPool();

        ex.execute(()->{
            StackClosedExample.add();
        });

        ex.execute(()->{
            StackClosedExample.add();
        });

        ex.shutdown();
    }
}
