package com.ly.设计模式.singleton;

/**
 * @Author: liyan
 * @Description:
 * @Date: Created in 16:59 2018/9/12
 * @Modified By:
 */
public class Singleton_Demo {

    // 饿汉模式
    static class Singleton_bad {
        private static Singleton_bad instance = new Singleton_bad();

        private Singleton_bad() {
        }// 私有化构造函数，禁止外部访问

        private static Singleton_bad getInstance() {
            return instance;
        }
    }

    // 懒汉模式
    static class Singleton_lazy {
        private static Singleton_lazy instance;

        private Singleton_lazy() {
        }

        private static Singleton_lazy getInstacne() {
            if (instance == null) {
                instance = new Singleton_lazy();
            }
            return instance;
        }
    }

    // 懒汉式 + 同步方法
    static class Singleton_synchronizedMethod {
        private static Singleton_synchronizedMethod instance;

        private Singleton_synchronizedMethod() {
        }

        private static synchronized Singleton_synchronizedMethod getInstance() {
            if (instance == null) {
                instance = new Singleton_synchronizedMethod();
            }
            return instance;
        }
    }

    // 懒汉式 + 同步代码块
    static class Singleton_synchronizedBlock {
        private static Singleton_synchronizedBlock instance;

        private Singleton_synchronizedBlock() {
        }

        private static Singleton_synchronizedBlock getInstance() {
            if (instance == null) {
                // 位置1
                synchronized (Singleton_synchronizedBlock.class) {
                    instance = new Singleton_synchronizedBlock();
                }
            }
            return instance;
        }
    }

    // 懒汉 + 双重非空检查
    static class Singleton_doubleNotNull{
        private static Singleton_doubleNotNull instance;
        private Singleton_doubleNotNull(){}
        private static Singleton_doubleNotNull getInstance() {
            if (instance == null) {
                // 位置1
                synchronized (Singleton_doubleNotNull.class) {
                    if (instance == null) {
                        instance = new Singleton_doubleNotNull();
                    }
                }
            }
            return instance;
        }
    }

    // 懒汉 + volatile终极版
    static class Singleton_volatile {
        private static volatile Singleton_volatile instance;
        private Singleton_volatile() {}
        private static Singleton_volatile getInstance() {
            if (instance == null) {
                synchronized (Singleton_volatile.class) {
                    if (instance == null) {
                        instance = new Singleton_volatile();
                    }
                }
            }
            return instance;
        }
    }


}
