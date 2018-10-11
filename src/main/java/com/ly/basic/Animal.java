package com.ly.basic;

/**
 * @Author: LiYan
 * @Description:
 * @Date: Created in 15:39 2018/9/26
 * @Modified By:
 */
public class Animal {
    public void A() {
        System.out.println("A");
    }
}

class Cat extends Animal {
    public void A() {
        System.out.println("AA");
    }

    public void B() {
        System.out.println("B");
    }

    public static void main(String[] args){
        Animal a = new Animal();
        a.A();
        Animal b = new Cat();
        b.A();
        ((Cat) b).B();
    }
}
