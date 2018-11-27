package io.file;

import java.io.*;

/**
 * 数据类型：基本类型+String)处理流
 *
 * 基本类型+String  保留数据+类型
 * 输入流：DataInputStream   readXxx
 * 输出流：DataOutputStream   writeXxx
 *
 *java.io.EOFException  :没有读取到相关的内容
 *
 * 操作读取的顺序必须与写出的顺序一致  且必须存在才能读取
 */
public class 处理流 {
    public static void main(String[] args) {
        try {
            write("D:/Java test/test/处理流.txt");
            read("D:/Java test/test/处理流.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void write(String path) throws IOException {
        double s1 = 20.1;
        long s2 = 213014914L;
        String s3 = "数据类型";

        //创建源
        File file = new File(path);

        //选择流
        DataOutputStream dos = new DataOutputStream(
                new BufferedOutputStream(
                        new FileOutputStream(file)
                )
        );
        dos.writeDouble(s1);
        dos.writeLong(s2);
        dos.writeUTF(s3);
        dos.flush();
        dos.close();
    }

    public static void read(String path) throws IOException {
        File file = new File(path);
        DataInputStream dis = new DataInputStream(
                new BufferedInputStream(
                        new FileInputStream(file)
                )
        );
        double s1 = dis.readDouble();
        long s2 = dis.readLong();
        String s3 = dis.readUTF();
        System.out.println(s1+"\t"+s2+"\t"+s3+"\t");
    }
}
