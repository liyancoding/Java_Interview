package com.ly.collections;

import org.apache.hadoop.util.hash.Hash;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Author: liyan
 * @Description:
 * @Date: Created in 10:55 2018/9/3
 * @Modified By:
 */
public class HashMap死循环 {
    public static void main(String[] args){
        HashMap<String, String> hashMap = new HashMap<>();

        ExecutorService executorService = Executors.newSingleThreadExecutor();
            for (int i=0;i<1000;i++) {
        executorService.execute(()->{
                hashMap.put(UUID.randomUUID().toString(), "");
        });
            }
        executorService.shutdown();

        Set<Map.Entry<String,String>> set = hashMap.entrySet();
        for (Map.Entry<String, String> map : set) {
            System.out.println(map.getKey() + " : " + map.getValue());
        }
    }
}
