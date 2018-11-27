package 防止父文件拷贝到子文件时出现无限拷贝的情况;

import io.file.拷贝文件_输入和输出一起使用;

import java.io.File;
import java.io.IOException;

public class copyDir {
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

            //防止父目录拷贝到子目录
            if(aim.getAbsolutePath().contains(source.getAbsolutePath())){
                System.out.println("父目录不能拷贝到子目录中");
                return;
            }
        }
        try {
            copyDirDetail(source,aim);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 拷贝文件夹细节
     * @param source
     * @param aim
     */
    public static void copyDirDetail(File source,File aim) throws IOException{
        if(source.isFile()){
            try {
                拷贝文件_输入和输出一起使用.copyFile(source,aim);
            } catch (IOException e) {
                //e.printStackTrace();
                throw e;
            }
        }else if(source.isDirectory()){
            // 确保目标路径存在
            aim.mkdirs();
            for(File temp:source.listFiles()){
                copyDirDetail(temp,new File(aim,temp.getName()));
            }
        }
    }
}
