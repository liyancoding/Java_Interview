package com.ly.collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @Author: liyan
 * @Description:
 * @Date: Created in 11:29 2018/8/8
 * @Modified By:
 */
public class Collections_Demo {
    public static void main(String[] args){
        List<String> list = new ArrayList<>();
        List<String> synList = Collections.synchronizedList(list);
        List<String> list1 = new CopyOnWriteArrayList<>();
    }
}

