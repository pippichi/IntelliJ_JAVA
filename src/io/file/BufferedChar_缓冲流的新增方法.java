package io.file;
/**
 * 字符缓冲流+新增方法
 */

import java.io.*;

public class BufferedChar_缓冲流的新增方法 {
    public static void main(String[] args) {
        File source = new File("C:/ob/c17/Ball.java");
        File aim = new File("D:/Java test/test/Ball.java");
        BufferedReader reader = null;
        BufferedWriter writer = null;
        try {
            reader =new BufferedReader( new FileReader(source));
            writer = new BufferedWriter(new FileWriter(aim,true));
            /*
            char[] str = new char[10];
            int len = 10;
            while((len=reader.read(str))!=-1){
                writer.write(str);
            }
            */
            String line = null;
            while((line=reader.readLine())!=null){
                writer.write(line);
                //writer.append("\r\n");
                writer.newLine(); //换行符号
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
