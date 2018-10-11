package com.ly.jvm;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Author: liyan
 * @Description:
 * @Date: Created in 14:29 2018/8/15
 * @Modified By:
 */
public class ReferenceCountingGCExample {

    private static final Logger LOGGER = LoggerFactory.getLogger(ReferenceCountingGCExample.class);

    private Object object = null;

    private static final int _1MB = 1024 * 1024;

    private byte[] bytes = new byte[_1MB * 2];

    public static void main(String[] args) {
        // 创建两个对象
        ReferenceCountingGCExample re1 = new ReferenceCountingGCExample();
        ReferenceCountingGCExample re2 = new ReferenceCountingGCExample();

        // 循环引用
        re1.object = re2;
        re2.object = re1;

        re1 = null;
        re2 = null;

        System.gc();

    }
}
