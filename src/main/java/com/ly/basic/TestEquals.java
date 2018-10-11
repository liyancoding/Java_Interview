package com.ly.basic;

/**
 * @Author: LiYan
 * @Description:
 * @Date: Created in 10:26 2018/9/25
 * @Modified By:
 */
public class TestEquals {
    public static void main(String[] args){
        String a = new String("abc"); // a为一个引用
        String b = new String("abc"); // b也为一个引用，和a内容一样
        String c = new String("abcd"); // c为一个引用，和a与b的内容不一样
        String s3 = "abc"; // "abc"放在常量池中
        String s4 = "abc"; // 从常量池中取出"abc"

        System.out.println(a == b); // false 比较的是a和b在栈中的内存首地址，这个肯定不一样
        System.out.println(a.equals(b)); // true 比较的是a和b在堆中new出来的内容，也就是"abc"，这个肯定返回true
        System.out.println(a.equals(c)); // false
        System.out.println(s3 == s4); // true
        System.out.println(s3.equals(s4)); // true
        System.out.println(a == s3); // false
        System.out.println(b.equals(s3)); // true
        System.out.println(a.equals(null)); // false
        System.out.println(42 == 42.0); // true

        int i = 10;
        Integer integer = new Integer(10);
        System.out.println(i == integer);
        System.out.println(integer.equals(i));

        String s = "s";
        String ss = new String(s);
        System.out.println(s == ss);
        System.out.println(s.equals(ss));


    }
}
