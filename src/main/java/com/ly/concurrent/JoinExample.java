package com.ly.concurrent;

import sun.awt.windows.ThemeReader;

/**
 * @Author: liyan
 * @Description: Thread类中的join()方法
 * @Date: Created in 10:42 2018/8/11
 * @Modified By:
 */
public class JoinExample {

    private class A extends Thread{

            @Override
            public void run() {
                System.out.println("A线程启动");
            }
    }

    private class B extends Thread{
        private A a;

        B(A a) {
            this.a = a;
        }

        @Override
        public void run() {
            try {
                a.join(); // 由于使用join()方法，所以在线程B执行之前先执行A线程。
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("B线程启动");

        }

    }

    public void func() {
        A a = new A();
        B b = new B(a);
        b.start();
        a.start();
    }

    public static void main(String[] args){
        JoinExample joinExample = new JoinExample();
        joinExample.func();
    }
}
