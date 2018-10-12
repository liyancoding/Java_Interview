package com.ly.设计模式.factory.factorymethod;

/**
 * @Author: LiYan
 * @Description:
 * @Date: Created in 20:47 2018/10/12
 * @Modified By:
 */

/*
创建邮件发送类实现Sender接口
 */
public class MailSender implements Sender {

    @Override
    public void send() {
        System.out.println("This is mail sender!");
    }
}
