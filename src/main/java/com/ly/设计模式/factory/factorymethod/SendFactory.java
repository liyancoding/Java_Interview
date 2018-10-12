package com.ly.设计模式.factory.factorymethod;



/**
 * @Author: LiYan
 * @Description:
 * @Date: Created in 20:50 2018/10/12
 * @Modified By:
 */

/*
创建工厂类
 */
public class SendFactory {

    public static Sender doMail() {
        return new MailSender();
    }

    public static Sender doSms() {
        return new SmsSender();
    }

    public static void main(String[] args){

        Sender sender = SendFactory.doMail();
        sender.send();

        Sender sender1 = SendFactory.doSms();
        sender1.send();

    }

}
