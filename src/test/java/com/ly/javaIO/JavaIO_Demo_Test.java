package com.ly.javaIO;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;

import static com.ly.javaIO.JavaIO_Demo.*;

/**
 * @Author: liyan
 * @Description:
 * @Date: Created in 10:30 2018/8/1
 * @Modified By:
 */
public class JavaIO_Demo_Test {

    private static final Logger LOGGER = LoggerFactory.getLogger(JavaIO_Demo_Test.class);

    @Test
    public void test_listAllDir() {
        File file = new File("E:\\Java_Interview");
        listAllDir(file);
        LOGGER.info("test successful");
    }

    @Test
    public void test_copyFile(){
        copyFile("E:\\Java_Interview\\test\\src.txt","E:\\Java_Interview\\test\\dist.txt");
        LOGGER.info("test successful");
    }

    @Test
    public void test_readFile() {
        readFile("E:\\Java_Interview\\test\\src.txt");
        LOGGER.info("test successful");
    }

    @Test
    public void test_writeFile() {
        writeFile("E:\\Java_Interview\\test\\src.txt","周茜我爱你");
        LOGGER.info("test successful");
    }

    @Test
    public void test_readFileContent(){
        readFileContent("E:\\Java_Interview\\test\\src.txt");
        LOGGER.info("test successful");
    }

    @Test
    public void test_readURLContent() {
        readURLContent("http://www.baidu.com");
        LOGGER.info("test successful");
    }

    @Test
    public void test_fastCopy() {
        fastCopy("E:\\Java_Interview\\test\\src.txt","E:\\Java_Interview\\test\\dist.txt");
        LOGGER.info("test successful");
    }

}
