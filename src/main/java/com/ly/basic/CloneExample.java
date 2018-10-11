package com.ly.basic;

/**
 * @Author: liyan
 * @Description:
 * @Date: Created in 21:38 2018/8/6
 * @Modified By:
 */
public class CloneExample implements Cloneable{
    private int x;
    private int y;

    CloneExample(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return "x = " + x + " y = " + y;
    }

    @Override
    protected CloneExample clone() throws CloneNotSupportedException {
        return (CloneExample) super.clone();
    }

    public static void main(String[] args) throws CloneNotSupportedException {
        CloneExample c = new CloneExample(1,2);
        CloneExample e = c.clone();
        System.out.println(c.toString());
        System.out.println(e.toString());
    }
}
