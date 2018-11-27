package io.file;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class 字符流写入io {
    public static void main(String[] args) {
        File file = new File("D:/Java test/test/char.txt");
        Writer w = null;
        try {
            w = new FileWriter(file,true);
            String str = "论焦虑症的治疗";
            w.write(str);
            w.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }finally{
            if(w!=null){
                try {
                    w.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
