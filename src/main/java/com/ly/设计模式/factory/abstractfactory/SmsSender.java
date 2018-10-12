package com.ly.设计模式.factory.abstractfactory;

/**
 * @Author: LiYan
 * @Description:
 * @Date: Created in 21:43 2018/10/12
 * @Modified By:
 */
public class SmsSender implements Sender {
    @Override
    public void send() {
        System.out.println("This is sms sender!");

    }
}
