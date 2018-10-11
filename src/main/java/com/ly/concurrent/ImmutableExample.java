package com.ly.concurrent;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author: liyan
 * @Description:
 * @Date: Created in 9:58 2018/8/14
 * @Modified By:
 */
public class ImmutableExample {
    public static void main(String[] args){

        Map<String, Integer> map = new HashMap<>();
        Map<String, Integer> unmodifiableMap = Collections.unmodifiableMap(map);

        unmodifiableMap.put("fuck u", 520);

        System.out.println(unmodifiableMap.get(0));
    }

    
}
