package io.file;

import java.io.File;
import java.io.IOException;

public class MyIoFile {
    public static void main(String[] args){
        File f = new File("C:/Users/HASEE/Desktop/new10 .txt");
        File f1 = new File("C:/Users/HASEE/Desktop");
        File f2 = new File(f1,"new10 .txt");
        System.out.println(f2.equals(f));
        if(f.isFile()){
            System.out.println("is file");
        }
        if(f1.isDirectory()){
            System.out.println("is directory");
        }


        File f3 = new File("C:/Users/HASEE/Desktop/new10.txt");
        try{
            f3.createNewFile();
        }catch(IOException e){
            e.printStackTrace();
        }
        f3.delete();

        File f4 = new File("C:/Users/HASEE/Desktop/aa/bb/bb/c");
        f4.mkdirs();
        deleteDir(f4);
        String[] temp = f4.list();
        File f5 = new File("C:/Users/HASEE/Desktop/cc");
        f5.mkdir();
        f5.delete();
    }
    public static boolean deleteDir(File file){
        if(file.isDirectory()) {
            String[] files = file.list();
            for(int i=0;i<files.length;i++){
                boolean success = deleteDir(new File(file,files[i]));
                if(!success){
                    return false;
                }
            }
        }
        return file.delete();
    }
}
