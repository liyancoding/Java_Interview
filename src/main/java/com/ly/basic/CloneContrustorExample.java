package com.ly.basic;

/**
 * @Author: liyan
 * @Description: 拷贝构造函数实现clone
 * @Date: Created in 22:31 2018/8/6
 * @Modified By:
 */
public class CloneContrustorExample {
    private int[] arr;

    CloneContrustorExample() {
        arr = new int[10];
        for (int i=0;i<arr.length;i++) {
            arr[i] = i * i;
        }
    }

    CloneContrustorExample(CloneContrustorExample cloneContrustorExample) {
        arr = new int[cloneContrustorExample.arr.length];
        for (int i=0;i<arr.length;i++) {
            arr[i] = cloneContrustorExample.arr[i];
//            arr[i] = i * i;
        }
    }

    public void set(int index, int val) {
        arr[index] = val;
    }

    public int get(int index) {
        return arr[index];
    }
    
    public static void main(String[] args){
        CloneContrustorExample c = new CloneContrustorExample();

        // 通过拷贝构造方法实现拷贝
        CloneContrustorExample c1 = new CloneContrustorExample(c);
        c.set(5, 555);
        System.out.println("c = " + c.get(5));
        System.out.println("c1 = " + c1.get(5));

    }
}
