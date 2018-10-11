package com.ly.basic;

/**
 * @Author: liyan
 * @Description:
 * @Date: Created in 10:23 2018/8/7
 * @Modified By:
 */
public class OuterClassExample {

    private static  int i;
    private String s;

    public static int get() {
        return i;
    }

    // 非静态内部类
    public class InnerClass {

    }

    public static class StaticInnerClass{

    }
    
    public static void main(String[] args){
//        InnerClass i = new InnerClass();
        OuterClassExample outerClassExample = new OuterClassExample();
        InnerClass innerClass = outerClassExample.new InnerClass();
        StaticInnerClass staticInnerClass = new StaticInnerClass();
    }
}
