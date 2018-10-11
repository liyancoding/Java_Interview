package com.ly.cache;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @Author: liyan
 * @Description:
 * @Date: Created in 10:17 2018/8/8
 * @Modified By:
 */
public class LRULinkedHashMapTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(LRUAbstractMapTest.class);

    @Test
    public void test_put() {

        LRULinkedHashMap<String, Integer> cacheMap = new LRULinkedHashMap<>(3);

        // 放数据
        for(int i=1;i<4;i++) {
            cacheMap.put(String.valueOf(i), i);
        }

        for (Map.Entry<String, Integer> map : cacheMap.getAll()) {
            System.out.print(map.getKey() + "::" + map.getValue() + "\t");
        }

        System.out.println("");

        cacheMap.put("4", 4);
        for (Map.Entry<String, Integer> map : cacheMap.getAll()) {
            System.out.print(map.getKey() + "::" + map.getValue() + "\t");
        }
    }

    @Test
    public void test_get() throws Exception{
        LRULinkedHashMap<String, Integer> cacheMap = new LRULinkedHashMap<>(3);

        for(int i=1;i<4;i++) {
            cacheMap.put(String.valueOf(i), i);
        }

        for (Map.Entry<String, Integer> map : cacheMap.getAll()) {
            System.out.print(map.getKey() + "::" + map.getValue() + "\t");
        }

        System.out.println("");

        cacheMap.get("1");

        for (Map.Entry<String, Integer> map : cacheMap.getAll()) {
            System.out.print(map.getKey() + "::" + map.getValue() + "\t");
        }
    }
}
