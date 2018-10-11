package com.ly.proxy.static_proxy;

/**
 * @Author: liyan
 * @Description:
 * @Date: Created in 11:22 2018/9/10
 * @Modified By:
 */
public class Client {
    public static void main(String[] args){
        HelloProxy hello = new HelloProxy();
        hello.sayHello();

    }
}
