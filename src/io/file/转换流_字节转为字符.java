package io.file;

import java.io.*;

/**
 * 转换流：字节转为字符
 * 1、输出流 OutputStreamWriter 编码
 * 2、输入流 InputStreamReader 解码
 */
public class 转换流_字节转为字符 {
    public static void main(String[] args) throws IOException {
        //指定字符集
        BufferedReader br = new BufferedReader(
                new InputStreamReader(
                        new FileInputStream(new File("D:/Java test/test/Ball.java")),"utf-8")
        );
        String info = null;

        while((info=br.readLine())!=null){
            System.out.println(info);
        }
        br.close();


        //写出文件
        BufferedWriter bw = new BufferedWriter(
                new OutputStreamWriter(
                      new FileOutputStream(
                             new File("D:/Java test/test/Ball1.java")),"utf-8")
        );
        String str = "public static void main(String[] args){}";
        bw.write(str);
        bw.flush();
        bw.close();
    }
}
