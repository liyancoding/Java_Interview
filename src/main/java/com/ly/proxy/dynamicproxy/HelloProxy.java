package com.ly.proxy.dynamicproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @Author: liyan
 * @Description:
 * @Date: Created in 12:25 2018/9/10
 * @Modified By:
 */
public class HelloProxy implements InvocationHandler {

    private Object object;

    public HelloProxy(Object object) {
        this.object = object;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("Before..." + method.getName());
        method.invoke(object);
        System.out.println("After..." + method.getName());
        return null;
    }
}
