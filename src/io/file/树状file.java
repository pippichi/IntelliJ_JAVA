package io.file;

import java.io.File;
import java.io.IOException;

public class 树状file {
    static void printFile(File file,int level){
        for(int i=0;i<level;i++){
            System.out.print("-");
        }
        System.out.println(file.getName());
        if(file.isDirectory()){
            File[] files = file.listFiles();
            for(File fileAll : files){
                printFile(fileAll,level+1);
            }
        }
    }
    public static void main(String[] args){
        File file = new File("C:/Users/HASEE/Desktop/aa1/bb/cc");
        file.mkdirs();
        File file1 = new File("C:/Users/HASEE/Desktop/aa1/bb/cc/x.txt");
        try {
            file1.createNewFile();
        }catch(IOException e){
            e.printStackTrace();
        }
        File file2 = new File("C:/Users/HASEE/Desktop/aa1");
        printFile(file2,0);
    }
}
