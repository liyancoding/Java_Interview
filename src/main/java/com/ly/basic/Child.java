package com.ly.basic;

/**
 * @Author: liyan
 * @Description:
 * @Date: Created in 19:32 2018/9/16
 * @Modified By:
 */
public class Child extends Parent {
    public int a = 20;

//    public Child() {
//        super();
//    }

    public void hello() {
//        super.hello();
        System.out.println("B");
    }
    
    public static void main(String[] args) {
        Child c = new Child();
        System.out.println(c.a); // 20
        c.hello();
        System.out.println(((Parent)c).a); // 10
        ((Parent)c).hello();
    }
}
