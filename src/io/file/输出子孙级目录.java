package io.file;

import java.io.File;
import java.util.Arrays;

/**
 * 输出子孙级目录|文件的名称(绝对路径)
 * 1、listFiles()   listRoots()根路径
 * 2、递归
 */
public class 输出子孙级目录 {
    public static void main(String[] args) {
        String path = "D:/Java test";
        File parent = new File(path);
        printName(parent);

        File[] files = File.listRoots();
        System.out.println(Arrays.toString(files));
    }
    public static void printName(File file){
        if(file==null||!file.exists()){
            return;
        }
        System.out.println(file.getAbsolutePath());
        File[] files = file.listFiles();
        if(file.isDirectory()){
            for(File temp:files){
                printName(temp);
            }
        }
    }
}
