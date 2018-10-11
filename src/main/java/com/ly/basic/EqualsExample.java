package com.ly.basic;

import java.util.HashSet;

/**
 * @Author: liyan
 * @Description:
 *  1：检查是否为同一个对象的引用，如果是直接返回true
 *  2：检查是否是同一个类型，如果不是，直接返回false
 *  3：将Object实例进行转型
 *  4：判断每个关键域是否相等
 * @Date: Created in 20:46 2018/8/6
 * @Modified By:
 */
public class EqualsExample {
    private int x;
    private int y;
    private int z;

    public EqualsExample(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    @Override
    public boolean equals(Object o) {
        // 检查是否为同一个对象的引用，如果是直接返回true
        if(this == o) return true;

        // 检查是否为同一个类型，如果不是，直接返回false
        if (o == null || getClass() != o.getClass()) return false;

        // 将Object实例进行转型，然后判断每一个关键域是否相等，不相等返回false
        EqualsExample equalsExample = (EqualsExample) o;
        if(x != equalsExample.x) return false;
        if (y != equalsExample.y) return false;
        return z == equalsExample.z;
    }

    @Override
    public int hashCode() {
        int result = 19;
        result = 31 * result + x;
        result = 31 * result + y;
        result = 31 * result + z;
        return result;
    }

    public static void main(String[] args){
        EqualsExample equalsExample = new EqualsExample(1, 2, 3);
        EqualsExample equalsExample1 = new EqualsExample(1,2,3);
        System.out.println(equalsExample.equals(equalsExample1));
        System.out.println(equalsExample.toString());

        HashSet<EqualsExample> hashSet = new HashSet<>();
        hashSet.add(equalsExample);
        hashSet.add(equalsExample1);
        System.out.println(hashSet.size());
    }
}
