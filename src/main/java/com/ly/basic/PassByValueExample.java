package com.ly.basic;

/**
 * @Author: liyan
 * @Description: Java的值传递特性
 * @Date: Created in 20:01 2018/8/6
 * @Modified By:
 */
public class PassByValueExample {
    public static void main(String[] args){
        Dog dog = new Dog("Candy");
        System.out.println(dog.getObjectAddress());
        func(dog);
        System.out.println(dog.getObjectAddress());
        System.out.println(dog.getName());
    }

    public static void func(Dog dog) {
        System.out.println(dog.getObjectAddress());
        dog = new Dog("Tom");
        System.out.println(dog.getObjectAddress());
        System.out.println(dog.getName());
    }
}
