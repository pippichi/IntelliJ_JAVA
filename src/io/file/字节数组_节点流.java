package io.file;

import java.io.*;

/**
 * 一、节点流
 * 数组的长度有限，数据量不会很大  1)文件-->程序-->字节数组  2)字节数组-->程序-->文件
 * 1、字节数组 节点流 字节
 * 输入流：ByteArrayInputStream    read(byte[]b,int off,int len)+close()
 * 输出流：ByteArrayOutputStream     write(byte[]b,int off,int len)+toByteArray()这是新增方法，不能用多态
 */
public class 字节数组_节点流 {
    /**
     * 输入流 操作与 文件输入流操作一致
     * 读取字节数组
     */
    public static void main(String[] args) throws IOException {
        read(write());
    }

    public static void read(byte[] bytes) throws IOException {
        //数据源
        //String msg = "操作与文件输入流操作一致";
        byte[] src = bytes;

        //选择流
        InputStream is = new BufferedInputStream(
                new ByteArrayInputStream(
                        src
                )
        );

        byte[] str = new byte[1024];
        int len = 0;
        while((len=is.read(str))!=-1){
            String s1 = new String(str,0,len);
            System.out.println(s1);
        }
        is.close();
    }

    public static byte[] write() throws IOException {
        //输出流 操作与文件输出流有些不同，有新增方法，不能使用多态

        //目的地
        byte[] aim;
        //选择流
        ByteArrayOutputStream bos = new ByteArrayOutputStream();

        //写出
        String str1 = "你瞒着所有人在爱谁？";
        byte[] bytes = str1.getBytes();
        bos.write(bytes,0,bytes.length);

        //获取数据
        aim = bos.toByteArray();
        //释放资源
        bos.close();
        return aim;
    }
}
