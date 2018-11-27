package io.file;

import java.io.*;

/**
 * 1、文件-->程序-->字节数组
 * 1）文件输入流
 *  字节数组输出流
 *
 * 2、字节数组-->程序-->文件
 * 1）字节数组输入流
 *  文件输出流
 */
public class 字节数组_文件输入输出流 {
    /**
     * 1、文件-->程序-->字节数组
     */
    public static void main(String[] args) throws IOException {
        byte[] temp = getBytesFromFile("D:/Java test/test/Ball.java");

        toFileFromByteArray(temp,"D:/Java test/test/Ball.txt");
    }


    public static byte[] getBytesFromFile(String srcPath) throws IOException {
        //创建文件源
        File file = new File(srcPath);
        //创建字节数组目的地
        byte[] aim = null;
        //选择流
        //文件输入流
        InputStream is = new BufferedInputStream(new FileInputStream(file));
        //字节数组输出流 不能使用多态
        ByteArrayOutputStream bos = new ByteArrayOutputStream();

        //操作 不断读取文件 写出到字节数组流中
        byte[] flush = new byte[1024];
        int len = 0;
        while((len=is.read(flush))!=-1){
            //写出到字节数组中
            bos.write(flush,0,len);
        }
        bos.flush();
        aim = bos.toByteArray();
        bos.close();
        is.close();

        return aim;
    }

    public static void toFileFromByteArray(byte[] src,String aimPath) throws IOException{
        //创建源
        //目的地
        File file = new File(aimPath);

        //选择流
        //字节数组输入流
        InputStream is = new BufferedInputStream(new ByteArrayInputStream(src));

        //文件输出流
        OutputStream os = new BufferedOutputStream(new FileOutputStream(file));

        byte[] temp = new byte[1024];
        int len = 0;
        while((len=is.read(temp))!=-1){
            os.write(temp,0,len);
        }
        os.flush();
        os.close();

    }
}
