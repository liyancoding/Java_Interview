package com.ly.cache;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @Author: liyan
 * @Description:
 * @Date: Created in 16:10 2018/8/8
 * @Modified By:
 */
public class LRUCache<K, V> extends LinkedHashMap<K, V> {
    private static final int MAX_SIZE = 3;

    @Override
    protected boolean removeEldestEntry(Map.Entry<K,V> eldest) {
        return size() > MAX_SIZE; // 当返回true的时候删除最近最久未使用的数据
    }

    LRUCache() {
        super(16, 0.75f, true);
    }
    
    public static void main(String[] args){

        LRUCache<String, Integer> map = new LRUCache<String, Integer>();

        map.put("1", 1);
        map.put("2", 2);
        map.put("3", 3);

        map.get("1");

        map.put("4", 4);

        System.out.println(map.keySet());
    }
}
