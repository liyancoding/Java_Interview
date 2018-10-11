package com.ly.javaIO;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.ByteBuffer;
import java.nio.channels.Channel;
import java.nio.channels.FileChannel;

/**
 * @Author: liyan
 * @Description: Java IO learning
 * @Date: Created in 10:24 2018/8/1
 * @Modified By:
 */
public class JavaIO_Demo {
    private static final Logger LOGGER = LoggerFactory.getLogger(JavaIO_Demo.class);

    /**
     * 递归输出一个目录下的所有文件
     * @param file
     */    
    public static void listAllDir(File file){
        try {
            if (file == null || !file.exists()) {
                return;
            }
            if (file.isFile()) {
                System.out.println(file.getName());
                return;
            }
            for (File file1 : file.listFiles()) {
                listAllDir(file1); // 递归
            }

        } catch (Exception e) {
            LOGGER.error("查找文件异常");
        }
    }

    /**
     * 使用字节流进行文件复制,把filePath1的内容复制到filePath2中，若filePath1不存在，则会报错误；若filePath2不存在，则会创建filePath2。
     * @param filePath1
     * @param filePath2
     * @throws IOException
     */
    public static void copyFile(String filePath1, String filePath2){
        try {
            FileInputStream fileInputStream = new FileInputStream(filePath1);
            FileOutputStream fileOutputStream = new FileOutputStream(filePath2);
            byte[] bytes = new byte[1024 * 100];
            // read()方法最多读取到bytes.length个字节
            // 返回的是实际读取的个数
            // 返回-1的时候表示读到eof，即文件末尾
            while (fileInputStream.read(bytes, 0, bytes.length) != -1) {
                fileOutputStream.write(bytes);
            }
            fileInputStream.close();
            fileOutputStream.close();
        } catch (Exception e) {
            LOGGER.error("文件不存在");
        }
    }

    /**
     * 字节流解码成字符流，逐行读取文件内容
     * @param filePath
     */
    public static void readFile(String filePath) {
        try {
            FileInputStream fileInputStream = new FileInputStream(filePath);
            InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);;
            char[] chars = new char[1024];
            int length = inputStreamReader.read(chars);
            LOGGER.info(new String(chars,0,length));
            inputStreamReader.close();
        } catch (Exception e) {
            LOGGER.error("文件不存在");
        }
    }

    /**
     * 字符流编码成字节流，写入文件内容
     * @param filePath
     * @param content
     */
    public static void writeFile(String filePath,String content) {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(filePath);
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(fileOutputStream);
            outputStreamWriter.write(content);
            outputStreamWriter.close();
        } catch (Exception e) {
            LOGGER.error("写入失败");
        }
    }

    /**
     * 逐行读取文件的内容。
     * 若是缺少line = bufferedReader.readLine();则会进入无限循环读取文件第一行内容，
     * 原因是在循环前读取了数据，s一直有值，判断条件一直成立，进入无限循环！！
     * @param filePath
     */
    public static void readFileContent(String filePath) {
        try {
            // 装饰者模式使得BufferedReader组合了一个Reader对象
            // 在调用BufferedReader的close()方法的时回去调用FileReader的close()方法，因此只需要一个close()调用即可
            FileReader fileReader = new FileReader(filePath);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line = bufferedReader.readLine();
            while (line != null) {
                LOGGER.info(line);
                line = bufferedReader.readLine(); // 若是缺少这局会进入无限循环
            }
            bufferedReader.close();
        } catch (Exception e) {
            LOGGER.error("读取失败或者文件不存在");
        }
    }

    /**
     * 可以直接从URL中读取字节流数据。
     * @param url
     */
    public static void readURLContent(String url) {
        try {
            URL url1 = new URL(url);
            // 字节流
            InputStream inputStream = url1.openStream();
            // 字符流
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream,"UTF-8");

            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

            String line = bufferedReader.readLine();
            while (line != null) {
                LOGGER.info(line);
                line = bufferedReader.readLine();
            }
            bufferedReader.close();
        } catch (Exception e) {
            LOGGER.error("URL错误");
        }
    }

    /**
     * NIO快速复制
     * @param filePath1
     * @param filePath2
     */
    public static void fastCopy(String filePath1,String filePath2) {
        try {
            // 获取源文件的输入字节流
            FileInputStream fileInputStream = new FileInputStream(filePath1);
            // 获取输入字节流的文件通道
            FileChannel fileChanne1 = fileInputStream.getChannel();

            // 获取源文件的输出字节流
            FileOutputStream fileOutputStream = new FileOutputStream(filePath2);
            // 获取输出字节流的文件通道
            FileChannel fileChanne2 = fileOutputStream.getChannel();

            // 为缓冲区分配1024个字节
            ByteBuffer byteBuffer = ByteBuffer.allocate(1024);

            while (true) {
                // 从输入通道中读取数据到缓冲区中
                int i = fileChanne1.read(byteBuffer);
                if (i == -1) {
                    break;
                }
                // 切换读写
                byteBuffer.flip();
                // 把缓冲区的数据写入输出文件
                fileChanne2.write(byteBuffer);
                // 清空缓冲区
                byteBuffer.clear();
            }
        } catch (Exception e) {
            LOGGER.error("快速读取发生错误");
        }
    }
}
