package com.ly.basic;

/**
 * @Author: LiYan
 * @Description:
 * @Date: Created in 14:46 2018/10/8
 * @Modified By:
 */
public class Test extends Base {
    public static void main(String[] args){
        new Test();
        new Base();
    }

}
class Base{
    Base(){
        System.out.println("Base");
    }
}
