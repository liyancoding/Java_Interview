package com.ly.concurrent;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/**
 * @Author: liyan
 * @Description: 实现Callable接口
 * @Date: Created in 14:37 2018/8/9
 * @Modified By:
 */
public class MyCallabel {
    
    public static void main(String[] args){
        Callable<String> ca = new Callable() {
            @Override
            public Object call() throws Exception {
                System.out.println("开启一个实现Callable接口的线程");
                return null;
            }
        };

        FutureTask<String> futureTask = new FutureTask<String>(ca);
        Thread thread = new Thread(futureTask);
        thread.start();
        System.out.println("Thread name: " + thread.getName());
    }
}
