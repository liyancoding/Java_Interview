package com.ly.basic;

/**
 * @Author: liyan
 * @Description:
 * @Date: Created in 11:09 2018/8/7
 * @Modified By:
 */
public class ArrayExample {
    public static void main(String[] args){
        Object[] strings = new String[2];
        strings[0] = "123";
        strings[1] = 100; // An ArrayStoreException throw
    }
}
