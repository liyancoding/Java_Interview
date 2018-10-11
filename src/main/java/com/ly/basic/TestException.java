package com.ly.basic;

import com.sun.prism.shader.Solid_ImagePattern_Loader;

/**
 * @Author: liyan
 * @Description:
 * @Date: Created in 15:08 2018/9/7
 * @Modified By:
 */
public class TestException {

    public static void main(String[] args) {
        try {
            int i = 9 / 0;
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("程序还在运行");
    }
}
