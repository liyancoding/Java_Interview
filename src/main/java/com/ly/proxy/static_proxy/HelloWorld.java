package com.ly.proxy.static_proxy;

/**
 * @Author: liyan
 * @Description: 被代理类
 * @Date: Created in 11:20 2018/9/10
 * @Modified By:
 */
public class HelloWorld implements Hello {


    @Override
    public void sayHello() {
        System.out.println("hello world!");
    }
}
