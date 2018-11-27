package io.file;
/**
 * 两个常量
 * 1、路径分隔符: ;
 * 2、名称分隔符: \(Windows) /(Linux 等)
 */

import java.io.File;

public class 为了跨平台的一些分隔符 {
    public static void main(String[] args) {
        System.out.println(File.pathSeparator);
        System.out.println(File.separator);
        //路径表示形式
        String path = "D:\\360\\360Safe\\360Safe.exe";
        path = "D:"+File.separator+"360"+File.separator+"360Safe"+File.separator+"360Safe.exe";
        //推荐方式
        path = "D:/360/360Safe/360Safe.exe";
        File file = new File(path);
    }
}
