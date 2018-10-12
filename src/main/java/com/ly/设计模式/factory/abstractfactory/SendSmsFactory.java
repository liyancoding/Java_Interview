package com.ly.设计模式.factory.abstractfactory;

/**
 * @Author: LiYan
 * @Description:
 * @Date: Created in 21:47 2018/10/12
 * @Modified By:
 */
public class SendSmsFactory implements Provider {
    @Override
    public Sender doAction() {
        return new SmsSender();
    }
}
