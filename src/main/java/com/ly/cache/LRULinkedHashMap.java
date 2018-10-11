package com.ly.cache;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @Author: liyan
 * @Description: LRU算法，删除最近最久未使用的数据
 * @Date: Created in 10:01 2018/8/8
 * @Modified By:
 */
public class LRULinkedHashMap<K,V> {

    private static final Logger LOGGER = LoggerFactory.getLogger(LRULinkedHashMap.class);
    /**
     * 定义一个缓存大小
     * 定义一个LinkedHashMap类型的缓存
     */
    private int cacheSize;

    private LinkedHashMap<K,V> cacheMap;

    public LRULinkedHashMap(int cacheSize) {
        this.cacheSize = cacheSize;

        cacheMap = new LinkedHashMap(16, 0.75f, true){
          @Override
          protected boolean removeEldestEntry(Map.Entry eldes) {
              if (cacheSize + 1 == cacheMap.size()) {
                  return true;
              } else {
                  return false;
              }
          }
        };
    }

    public void put(K k, V v) {
        cacheMap.put(k, v);
    }

    public V get(K k) {
        return cacheMap.get(k);
    }

    public Collection<Map.Entry<K,V>> getAll() {
        return new ArrayList<>(cacheMap.entrySet());
    }
}
