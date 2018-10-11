package com.ly.futureConcurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Author: liyan
 * @Description:
 * @Date: Created in 14:15 2018/8/16
 * @Modified By:
 */
public class ReOrder {
    private int i = 0;

    private boolean flag = false;

    public void writer() {
        i = 1;
        flag = true;
        System.out.println("i = " + i);
    }

    public void reader() {
        if (flag) {
            int a = i * i;
            System.out.println("a = " + a);
        }
    }
    
    public static void main(String[] args){

        ReOrder re = new ReOrder();

        ExecutorService ex = Executors.newCachedThreadPool();

        ex.execute(()->{
            for (int i=0;i<10;i++)
                re.writer();
        });

        ex.execute(()->{
            re.reader();
        });

        ex.shutdown();
    }
}
