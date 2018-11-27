package io.file;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;

public class 取出文件中的子文件或子文件路径 {
    public static void main(String[] args) throws IOException {
        String path = "C:/Users/HASEE/Desktop";
        File dir = new File(path,"test");
        dir.mkdir();
        File file1 = new File(path+"/test","test1.txt");
        File file2 = new File(path+"/test","test2.txt");
        File file3 = new File(path+"/test","test3.txt");

        file1.createNewFile();
        file2.createNewFile();
        file3.createNewFile();
        System.out.println("=======子目录|文件名========");
        childName(dir);
        System.out.println("=======子目录|文件File对象========");
        absoluteName(dir);
        System.out.println("=======子文件，Java对象========");
        //命令设计模式
        filterFile(dir,".java");
    }
    public static void childName(File file){
        if(file.isDirectory()){
            String[] name = file.list();
            for(String temp:name){
                System.out.println(temp);
            }
        }
    }
    public static void absoluteName(File file){
        if(file.isDirectory()){
            File[] ele = file.listFiles();
            for(File temp:ele){
                System.out.println(temp.getAbsolutePath());
            }
        }
    }
    public static void filterFile(File file,String name){
        File[] dir = file.listFiles(
                new FilenameFilter(){
                    @Override
                    public boolean accept(File file1,String name){
                        return new File(file1,name).isFile()&&name.endsWith(".java");
                    }
                }
        );
        for(File temp:dir){
            System.out.println(temp.getAbsolutePath());
        }
    }
}
