package com.ly.设计模式.factory.simplefactory;

/**
 * @Author: LiYan
 * @Description: https://blog.csdn.net/llussize/article/details/80276627
 * @Date: Created in 20:50 2018/10/12
 * @Modified By:
 */

/*
创建工厂类
 */
public class SendFactory {
    public Sender doSend(String type) {
        if ("mail".equals(type)) {
            return new MailSender();
        } else if ("sms".equals(type)) {
            return new SmsSender();
        } else {
//            System.out.println("请输入正确的类型！！");
            return null;
        }
    }

    public static void main(String[] args){
        SendFactory sf = new SendFactory();
        Sender sender = sf.doSend("mail");
        sender.send();
        Sender sender1 = sf.doSend("sms");
        sender1.send();
//        Sender sender2 = sf.doSend("type");
//        sender2.send();
    }

}
