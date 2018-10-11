package com.ly.javaIO;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

/**
 * @Author: liyan
 * @Description:
 * @Date: Created in 10:27 2018/8/6
 * @Modified By:
 */
public class NIOClient {

    private static final Logger LOGGER = LoggerFactory.getLogger(NIOClient.class);

    public static void main(String[] args){
        try {
            Socket socket = new Socket("127.0.0.1", 8384);

            OutputStream outputStream = socket.getOutputStream();

            String s = "java interview";
            outputStream.write(s.getBytes());
            outputStream.close();
        } catch (IOException e) {
            LOGGER.error("发生错误");
        }
    }
}
