package io.file;

import java.io.*;

/**
 * 纯文本 ，.txt;.html
 */

public class 字符流io {
    public static void main(String[] args) {
        File file = new File("D:/Java test/test/test2.txt");
        Reader reader = null;
        try {
            reader = new FileReader(file);
            char[] str = new char[10];
            int len = 0;
            while((len=reader.read(str))!=-1){
                String s = new String(str,0,len);
                System.out.println(s);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("找不到文件");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("文件读入错误");
        }finally{
            if(reader!=null){
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                    System.out.println("关闭错误");
                }
            }
        }
    }
}
