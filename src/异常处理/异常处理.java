package 异常处理;

import java.io.*;
import java.util.ArrayList;

public class 异常处理 {
    public static void main(String[] args) {
        FileWriter writer = null;
        FileReader reader = null;
        File f1 = new File("C:/Users/HASEE/Desktop/text1.txt");
        try {
            f1.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            writer = new FileWriter("C:/Users/HASEE/Desktop/text1.txt");
            writer.write("this is my life\nthis is my wife\tyes!");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (writer != null) {
                    writer.flush();
                    writer.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        try {
            reader = new FileReader(f1);
            char[] c2 = new char[50];
            reader.read(c2);
            System.out.println(c2);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (reader != null) {
                    reader.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        f1.delete();
    }
}
