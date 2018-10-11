package com.ly.proxy.dynamicproxy;

import com.ly.proxy.static_proxy.HelloProxy;

/**
 * @Author: liyan
 * @Description:
 * @Date: Created in 12:25 2018/9/10
 * @Modified By:
 */
public class HelloWorld implements Hello {
    @Override
    public void sayHello() {
        System.out.println("动态代理");
    }
}
