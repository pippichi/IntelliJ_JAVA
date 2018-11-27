package io.file;

import java.io.*;

public class 字符流拷贝 {
    public static void main(String[] args) {
        File source = new File("C:/ob/c17/Ball.java");
        File aim = new File("D:/Java test/test/Ball.java");
        Reader reader = null;
        Writer writer = null;
        try {
            reader = new FileReader(source);
            writer = new FileWriter(aim,true);
            char[] str = new char[10];
            int len = 10;
            while((len=reader.read(str))!=-1){
                writer.write(str);
            }
            writer.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally{
            try {
                writer.close();
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
