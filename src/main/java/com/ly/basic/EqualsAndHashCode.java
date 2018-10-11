package com.ly.basic;

/**
 * @Author: liyan
 * @Description:
 * @Date: Created in 9:13 2018/9/18
 * @Modified By:
 */
public class EqualsAndHashCode {
    private int id;
    private String name;

    public EqualsAndHashCode(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return true;
    }

    public static void main(String[] args){
        String s1 = "helloworld";
        String s2 = "helloworld";
        System.out.println(s1.equals(s2));
        System.out.println(s1==s2);
        System.out.println(s1.hashCode());
        System.out.println(s2.hashCode());

        StringBuffer stringBuffer = new StringBuffer("stringBuffer");
        StringBuffer stringBuffer1 = stringBuffer;
        System.out.println(stringBuffer.equals(stringBuffer1));
        System.out.println(stringBuffer == stringBuffer1);
        System.out.println(stringBuffer.hashCode());
        System.out.println(stringBuffer1.hashCode());

        EqualsAndHashCode equalsAndHashCode = new EqualsAndHashCode(15, "p");
        EqualsAndHashCode equalsAndHashCode1 = new EqualsAndHashCode(15, "p");
        System.out.println(equalsAndHashCode.equals(equalsAndHashCode1));
        System.out.println(equalsAndHashCode.hashCode());
        System.out.println(equalsAndHashCode1.hashCode());

    }

}
