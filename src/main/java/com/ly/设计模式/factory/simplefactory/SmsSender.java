package com.ly.设计模式.factory.simplefactory;

/**
 * @Author: LiYan
 * @Description:
 * @Date: Created in 20:49 2018/10/12
 * @Modified By:
 */

/*
创建短信发送类，实现Sender接口
 */
public class SmsSender implements Sender {
    @Override
    public void send() {
        System.out.println("This is sms sender!");
    }
}
