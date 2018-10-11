package com.ly.javaIO;

import com.sun.org.apache.bcel.internal.generic.Select;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

/**
 * @Author: liyan
 * @Description:
 * @Date: Created in 10:37 2018/8/6
 * @Modified By:
 */
public class NIOServer {
    public static void main(String[] args) throws IOException {
        // 创建选择器
        Selector selector = Selector.open();

        // 将通道注册到选择器上
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.configureBlocking(false); // 将通道配置为非阻塞的
        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);

        ServerSocket serverSocket = serverSocketChannel.socket();
        InetSocketAddress address = new InetSocketAddress("127.0.0.1", 8080);
        serverSocket.bind(address);

        while (true) {
            // 监听事件
            selector.select();

            Set<SelectionKey> keys = selector.selectedKeys();
            Iterator<SelectionKey> iterator = keys.iterator();

            while (iterator.hasNext()) {
                SelectionKey key = iterator.next();
                if (key.isAcceptable()) {
                    ServerSocketChannel serverSocketChannel1 = (ServerSocketChannel) key.channel();

                    // 服务器为每一个新的连接创建一个SocketChannel
                    SocketChannel socketChannel = serverSocketChannel.accept();
                    socketChannel.configureBlocking(false);

                    // 这个新的连接主要用于从客户端读取数据
                    socketChannel.register(selector, SelectionKey.OP_READ);
                } else if (key.isReadable()) {
                    SocketChannel socketChannel = (SocketChannel) key.channel();
                    System.out.println(readDataFromSocketChannel(socketChannel));
                    socketChannel.close();
                }
                iterator.remove();
            }
        }

    }

    /**
     *
     * @param socketChannel
     * @return
     * @throws IOException
     */
    private static String readDataFromSocketChannel(SocketChannel socketChannel) throws IOException {

        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
        // 存放数据
        StringBuilder stringBuilder = new StringBuilder();

        while (true) {
            byteBuffer.clear();
            int n = socketChannel.read(byteBuffer);
            if (n == -1) {
                break;
            }
            byteBuffer.flip();
            int limit = byteBuffer.limit();
            char[] chars = new char[limit];
            for (int i=0;i<limit;i++) {
                chars[i] = (char) byteBuffer.get(i);
            }
            stringBuilder.append(chars);
            byteBuffer.clear();
        }

        return stringBuilder.toString();
    }
}
