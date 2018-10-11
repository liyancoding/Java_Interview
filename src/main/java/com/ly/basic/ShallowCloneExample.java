package com.ly.basic;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import sun.security.provider.SHA;

/**
 * @Author: liyan
 * @Description: 浅拷贝
 * @Date: Created in 21:56 2018/8/6
 * @Modified By:
 */
public class ShallowCloneExample implements Cloneable {

    private static final Logger LOGGER = LoggerFactory.getLogger(ShallowCloneExample.class);
    private int[] arr;

    public ShallowCloneExample() {
        arr = new int[10];
        for (int i =0;i<arr.length;i++) {
            arr[i] = i;
        }
    }

    public void set(int index, int value) {
        arr[index] = value;
    }

    public int get(int index) {
        return arr[index];
    }

    @Override
    protected ShallowCloneExample clone() throws CloneNotSupportedException {
        return (ShallowCloneExample) super.clone();
    }

    public static void main(String[] args){
        ShallowCloneExample shallowCloneExample = new ShallowCloneExample();
        ShallowCloneExample shallowCloneExample1 = null;

        try {
            shallowCloneExample1 = shallowCloneExample.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        shallowCloneExample.set(5, 10);
        System.out.println("shallowCloneExample = " + shallowCloneExample1.get(5));
        shallowCloneExample1.set(5, 15);
        System.out.println("shallowCloneExample1 = " + shallowCloneExample1.get(5));
        System.out.println("shallowCloneExample = " + shallowCloneExample.get(5));
    }
}
