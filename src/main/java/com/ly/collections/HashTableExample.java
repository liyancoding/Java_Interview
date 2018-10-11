package com.ly.collections;

import java.util.Dictionary;
import java.util.Hashtable;

/**
 * @Author: liyan
 * @Description:
 * @Date: Created in 10:47 2018/9/3
 * @Modified By:
 */
public class HashTableExample {
    public static void main(String[] args){
        Dictionary<Integer, String> dic = new Hashtable<>();

        dic.put(1, null);
        dic.put(2, "a");
        dic.put(3, "c");

        System.out.println(dic.get(2));

    }
}
