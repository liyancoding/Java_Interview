package com.ly.proxy.dynamicproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @Author: liyan
 * @Description:
 * @Date: Created in 12:28 2018/9/10
 * @Modified By:
 */
public class Client {
    public static void main(String[] args){
        HelloWorld hw = new HelloWorld();

        InvocationHandler invocationHandler = new HelloProxy(hw);

        Hello hello = (Hello) Proxy.newProxyInstance(invocationHandler.getClass().getClassLoader(),
                hw.getClass().getInterfaces(), invocationHandler);

        hello.sayHello();

    }
}
