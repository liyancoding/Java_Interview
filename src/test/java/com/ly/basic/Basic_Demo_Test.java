package com.ly.basic;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.ly.basic.Basic_Demo.contrastString;
import static com.ly.basic.Basic_Demo.conversionDataType;

/**
 * @Author: liyan
 * @Description:
 * @Date: Created in 14:50 2018/8/6
 * @Modified By:
 */
public class Basic_Demo_Test {
    private static final Logger LOGGER = LoggerFactory.getLogger(Basic_Demo_Test.class);

    @Test
    public void test_conversionDataType() {
        conversionDataType(-127);
        LOGGER.info("OK");
    }

    @Test
    public void test_contrastString() {
        contrastString("zhouqian");
        LOGGER.info("OK");
    }
}
