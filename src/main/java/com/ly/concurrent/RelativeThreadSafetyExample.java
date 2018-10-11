package com.ly.concurrent;

import java.util.Vector;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Author: liyan
 * @Description:
 * @Date: Created in 11:24 2018/8/14
 * @Modified By:
 */
public class RelativeThreadSafetyExample {
    private static Vector<Integer> vector = new Vector<>();
    
    public static void main(String[] args){
        while (true) {
            for (int i=0;i<100;i++) {
                vector.add(i);
            }

            ExecutorService executorService = Executors.newCachedThreadPool();

//            executorService.execute(()->{
//                for (int i=0;i<vector.size();i++) {
//                    vector.remove(i);
//                }
//            });
//
//            executorService.execute(()->{
//                for (int i=0;i<vector.size();i++) {
//                    System.out.print(vector.get(i));
//                }
//            });

            executorService.execute(()->{
                synchronized (vector) {
                    for (int i=0;i<vector.size();i++) {
                        vector.remove(i);
                    }
                }
            });

            executorService.execute(()->{
                synchronized (vector) {
                    for (int i=0;i<vector.size();i++) {
                        System.out.println(vector.get(i));
                    }
                }
            });

            executorService.shutdown();
        }
    }
}
