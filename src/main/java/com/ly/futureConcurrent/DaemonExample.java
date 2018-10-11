package com.ly.futureConcurrent;

/**
 * @Author: liyan
 * @Description:
 * @Date: Created in 15:07 2018/8/16
 * @Modified By:
 */
public class DaemonExample {
    
    public static void main(String[] args){
        Thread th = new Thread(()->{
            try {
                SleepUtils.second(5); // 让守护线程休眠5秒后在执行，此时main线程已经执行完毕，finally块中不一定执行。
            }finally {
                System.out.println("DaemonThread finally run."); // Java虚拟机退出时，Daemon线程中的finally块不一定执行。
            }
//            try {
//                Thread.sleep(5000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }finally {
//                System.out.println("DaemonThread finally run.");
//            }
        });

        System.out.println(Thread.currentThread().getName()); // main

        th.setDaemon(true);
        th.start();
    }
}
