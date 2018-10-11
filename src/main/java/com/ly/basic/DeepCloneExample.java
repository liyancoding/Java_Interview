package com.ly.basic;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Author: liyan
 * @Description:
 * @Date: Created in 22:10 2018/8/6
 * @Modified By:
 */
public class DeepCloneExample implements Cloneable {

    private static final Logger LOGGER = LoggerFactory.getLogger(DeepCloneExample.class);
    private int[] arr;

    public DeepCloneExample() {
        arr = new int[10];
        for (int i = 0; i < arr.length; i++) {
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
    protected DeepCloneExample clone() throws CloneNotSupportedException {
        DeepCloneExample d = (DeepCloneExample) super.clone();
        d.arr = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            d.arr[i] = i * i;
        }
        return d;
    }

    public static void main(String[] args) {
        DeepCloneExample d = new DeepCloneExample();
        DeepCloneExample d1 = null;
        try {
            d1 = d.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        d.set(5, 55);
        System.out.println("d = " + d.get(5));
        System.out.println("d1 = " + d1.get(5));

        d1.set(5, 555);
        System.out.println("d = " + d.get(5));
        System.out.println("d1 = " + d1.get(5));
    }
}