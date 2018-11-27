package io.file;

/**
 * 相对路径与绝对路径构造File对象
 * 1、相对路径
 *    File(String parentPath,String child)
 *    File(File parentPath,String child)
 * 2、绝对路径
 *    File(String name)
 *
 * 方法：
 * getPath()  getParent()  getAbsolutePath()  getName()  getAbsoluteFile()
 * createNewFile() 不存在创建文件，存在则返回false
 * delete()  deleteOnExit() 退出时删除
 * static createTempFile(前缀3个字节长，后缀默认.temp) 默认临时空间
 * static createTempFile(前缀3个字节长，后缀默认.temp，目录)
 */

import java.io.File;
import java.io.IOException;

public class 创建文件路径的方法以及临时文件的生成 {
    public static void main(String[] args) throws IOException, InterruptedException {
        //相对路径
        String parentPath = "D:/360/360Safe";
        String name = "360Safe.exe";
        File file = new File(parentPath,name);
        File file1 = new File(new File(parentPath),name);
        System.out.println(file.getName());
        System.out.println(file.getParent());
        System.out.println(file.getPath());
        //绝对路径
        File file2 = new File("D:\\360\\360Safe\\360Safe.exe");

        //没有盘符，以user.dir创建
        File file3 = new File("test.txt");
        System.out.println(file3.getName());
        System.out.println(file3.getPath());
        System.out.println(file3.getAbsolutePath());

        // . 表示当前路径
        File file4 = new File(".");
        System.out.println(file4.getName());
        System.out.println(file4.getPath());
        System.out.println(file4.getAbsolutePath());
        System.out.println(file4.getParent());


        //static createTempFile(前缀3个字节长，后缀默认.temp) 默认临时空间
        //static createTempFile(前缀3个字节长，后缀默认.temp，目录)
        String path = "C:\\Users\\HASEE\\Desktop\\aa";
        File text = null;
        try {
            text = new File(path);
            text.mkdir();
            File text1 = new File(path, "text.txt");
            text1.createNewFile();
            Thread.sleep(1000);
            text1.delete();
            //下面这行代码最后的aa是个文件夹
            File temp = File.createTempFile("aaa", ".temp", text);
            File temp2 = text1.createTempFile("bbb", ".java", text);
            Thread.sleep(1000);
            temp.deleteOnExit();
            temp2.deleteOnExit();
            Thread.sleep(1000);
        }
        finally {
            while(text.exists())
                System.out.println(text.delete());
        }

    }
}
