package com.ly.concurrent;

import java.util.Vector;

/**
 * @Author: liyan
 * @Description: 绝对线程安全和相对线程安全
 * 尽管Vector的add()、get()、remove()以及size()方法都是同步的，但是在多线程环境中，不采用额外的同步措施，
 * 使用这段代码仍然是不安全的。
 * @Date: Created in 10:10 2018/8/14
 * @Modified By:
 */
public class AbsoluteThreadSafetyExample {
    private static Vector<Integer> vector = new Vector<>();
    
    public static void main(String[] args){
        while (true) {
            for (int i=0;i<10;i++) {
                vector.add(i);
            }

//            Thread thread = new Thread(new Runnable() {
//                @Override
//                public void run() {
//                    for(int i=0;i<vector.size();i++) {
//                        vector.remove(i);
//                    }
//                }
//            });
//
//            Thread thread1 = new Thread(new Runnable() {
//                @Override
//                public void run() {
//                    for (int i=0;i<vector.size();i++) {
//                        System.out.print(vector.get(i));
//                    }
//                }
//            });

            // 若是要保证代码正确的执行下去，我们不得不把thread和thread1改成如下方式：
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    synchronized (vector) {
                        for (int i=0;i<vector.size();i++) {
                            vector.remove(i);
                        }
                    }
                }
            });

            Thread thread1 = new Thread(new Runnable() {
                @Override
                public void run() {
                    synchronized (vector) {
                        for (int i=0;i<vector.size();i++) {
                            System.out.print(vector.get(i));
                        }
                    }
                }
            });

            thread.start();
            thread1.start();

//            while (Thread.activeCount() > 20) {
//
//            }
        }
    }
}
