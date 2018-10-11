package com.ly.basic;

/**
 * @Author: liyan
 * @Description:
 * @Date: Created in 16:44 2018/8/6
 * @Modified By:
 */
public class Dog {
    String name;

    Dog(String name) {
        this.name = name;
    }

    String getName() {
        return name;
    }

    String getObjectAddress() {
        return super.toString();
    }
}
