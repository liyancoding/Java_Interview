package com.ly.basic;

/**
 * @Author: liyan
 * @Description:
 * @Date: Created in 10:18 2018/8/7
 * @Modified By:
 */
public class StaticExample {

    private String s;
    private int i;

    StaticExample(String s, int i) {
        this.s = s;
        this.i = i;
    }

    static {
        System.out.println("fucking you");
    }

    @Override
    public String toString() {
        return s + "," + i;
    }
    
    public static void main(String[] args){
        StaticExample s1 = new StaticExample("social",5);
        StaticExample s2 = new StaticExample("school",1);
        System.out.println(s1.toString());
        System.out.println(s2.toString());
    }
}
