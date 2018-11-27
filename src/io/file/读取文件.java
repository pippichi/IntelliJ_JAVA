package io.file;

import java.io.*;

public class 读取文件 {
    public static void main(String[] args) {
        //建立File 对象
        File file = new File("D:/Java test/test/test3.txt");
        //选择流
        InputStream is = null;//提升作用域
        try {
            is = new FileInputStream(file);
            //操作不断读取，缓冲数组
            byte[] car = new byte[10];
            int len = 0;//实际读取大小
            //循环读取
            while((len=is.read(car))!=-1){
                //输出，字节转字符串
                String info = new String(car,0,len);
                System.out.println(info);

            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("文件不存在");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("读取文件失败");
        }finally{
            if(is!=null){
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                    System.out.println("关闭文件输入流失败");
                }
            }
        }
    }
}
