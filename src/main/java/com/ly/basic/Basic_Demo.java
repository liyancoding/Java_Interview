package com.ly.basic;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Author: liyan
 * @Description:
 * @Date: Created in 14:50 2018/8/6
 * @Modified By:
 */
public class Basic_Demo {
    private static final Logger LOGGER = LoggerFactory.getLogger(Basic_Demo.class);

    /**
     * 基本数据类型和包装类型的转换
     * @param i
     */
    public static void conversionDataType(int i) {
        Integer integer = new Integer(i);
        Integer integer1 = new Integer(i);
        System.out.println(integer == integer1); // false

        Integer integer2 = Integer.valueOf(i);
        Integer integer3 = Integer.valueOf(i);
        System.out.println(integer2 == integer3); // true

        // 自动装箱
        Integer integer4 = i;
        Integer integer5 = i;
        System.out.println(integer4 == integer5); // true
    }

    /**
     * String测试
     * @param s
     */
    public static void contrastString(String s) {
        String s1 = new String(s);
        String s2 = new String(s);
        System.out.println(s1 == s2); // false

        String s3 = s1.intern();
        System.out.println(s1.intern() == s3);

        String s4 = s;
        String s5 = s;
        System.out.println(s4 == s5); // true
    }
}
