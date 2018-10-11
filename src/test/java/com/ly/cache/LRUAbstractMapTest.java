package com.ly.cache;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Author: liyan
 * @Description:
 * @Date: Created in 14:50 2018/8/1
 * @Modified By:
 */
public class LRUAbstractMapTest {
    private static final Logger LOGGER = LoggerFactory.getLogger(LRUAbstractMapTest.class);

    @Test
    public void test(){
        LRUAbstractMap map = new LRUAbstractMap() ;
        map.put(1,1) ;
        map.put(2,2) ;

        Object o = map.get(1);
        LOGGER.info("getSize={}",map.size());

        map.remove(1) ;
        LOGGER.info("getSize" + map.size());
    }
}
