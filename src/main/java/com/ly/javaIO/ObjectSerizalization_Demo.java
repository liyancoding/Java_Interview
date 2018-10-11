package com.ly.javaIO;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import sun.applet.Main;

import java.io.*;
import java.net.InetAddress;

/**
 * @Author: liyan
 * @Description:
 * @Date: Created in 11:22 2018/8/2
 * @Modified By:
 */
public class ObjectSerizalization_Demo implements Serializable {

    private static final Logger LOGGER = LoggerFactory.getLogger(ObjectSerizalization_Demo.class);

    private int i;
    private String s;

    public ObjectSerizalization_Demo(int i, String s) {
        this.i = i;
        this.s = s;
    }

    @Override
    public String toString(){
        return "i = " + i + " s = " + s;
    }
    
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ObjectSerizalization_Demo obj = new ObjectSerizalization_Demo(100, "我们100天啦！");

        String s = "E:\\Java_Interview\\test\\blank.txt";

        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(s));
        objectOutputStream.writeObject(obj);
        objectOutputStream.close();

        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(s));
        ObjectSerizalization_Demo objectSerizalization_demo = (ObjectSerizalization_Demo) objectInputStream.readObject();
        System.out.println(objectSerizalization_demo);
        objectInputStream.close();

    }

}
