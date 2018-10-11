package com.ly.proxy.static_proxy;

/**
 * @Author: liyan
 * @Description:
 * @Date: Created in 11:20 2018/9/10
 * @Modified By:
 */
public class HelloProxy implements Hello {

    Hello hello = new HelloWorld();

    @Override
    public void sayHello() {
        System.out.println("Before.....");
        hello.sayHello();
        System.out.println("After....");
    }
}
