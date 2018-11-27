package io.file;

import java.io.File;
import java.io.IOException;

public class 文件夹的拷贝 {
    public static void main(String[] args) {
        String s1 = "D:/Java test/test";
        String s2 = "D:/Java test/dir";
        copyDir(s1,s2);
    }

    public static void copyDir(String src,String destPath){
        File source = new File(src);
        File aim = new File(destPath);
        copyDir(source,aim);
    }
    public static void copyDir(File source,File aim){
        if(source.isDirectory()){
            aim = new File(aim,source.getName());
        }
        try {
            copyDirDetail(source,aim);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 拷贝文件夹细节
     * @param src
     * @param aim
     */
    public static void copyDirDetail(File src,File aim) throws IOException{
        if(src.isFile()){
            try {
                拷贝文件_输入和输出一起使用.copyFile(src,aim);
            } catch (IOException e) {
                //e.printStackTrace();
                throw e;
            }
        }else if(src.isDirectory()){
           // 确保目标路径存在
            aim.mkdirs();
            for(File temp:src.listFiles()){
                copyDirDetail(temp,new File(aim,temp.getName()));
            }
        }
    }
}
