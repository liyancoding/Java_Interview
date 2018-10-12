package com.ly.设计模式.factory.abstractfactory;

/**
 * @Author: LiYan
 * @Description:
 * @Date: Created in 21:48 2018/10/12
 * @Modified By:
 */
public class Test {
    public static void main(String[] args){
        Provider pro = new SendMailFactory();
        Sender sender = pro.doAction();
        sender.send();

        Provider pro1 = new SendSmsFactory();
        Sender sender1 = pro1.doAction();
        sender1.send();
    }
}
