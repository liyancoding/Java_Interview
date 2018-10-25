package com.ly.basic;

/**
 * @Author: LiYan
 * @Description:
 * @Date: Created in 19:29 2018/10/22
 * @Modified By:
 */
public class A{
    int i = 10;
}
class B{
    final A a = new A();
    public static void main(String[] args){
        B b = new B();
        b.a.i++;
    }
}

