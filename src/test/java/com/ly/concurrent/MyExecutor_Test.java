package com.ly.concurrent;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.TestExecutionListeners;

import static com.ly.concurrent.MyExecutor.*;


/**
 * @Author: liyan
 * @Description:
 * @Date: Created in 10:47 2018/8/10
 * @Modified By:
 */
public class MyExecutor_Test {

    private static final Logger LOGGER = LoggerFactory.getLogger(MyExecutor_Test.class);

    RunnableExecutor re = new RunnableExecutor();

    @Test
    public void test_newCachedThreadPoolMethod() {

        newCachedThreadPoolMethod(re);

        LOGGER.info("OK");
    }

    @Test
    public void test_newFixedThreadPoolMethod() {

        newFixedThreadPoolMethod(re);

        LOGGER.info("OK");
    }

    @Test
    public void test_newSingleThreadPoolMethod() {

        newSingleThreadPoolMethod(re);

        LOGGER.info("OK");
    }

    @Test
    public void test_newScheduledThreadPoolMethod() {

        newScheduledThreadPoolMethod(re);

        LOGGER.info("OK");
    }
}
