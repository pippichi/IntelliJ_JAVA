package io.file;

import java.io.File;
import java.io.IOException;

/**
 * 判断信息
 * createNewFile() 不存在创建新文件，存在返回false
 * exists()  isFile()  isDirectory()  canWrite()  canRead()  isAbsolute():消除平台差异，ie以盘符开头，其他以/开头
 */
public class 读取文件的属性 {
    public static void main(String[] args) {
        File file = new File("C:/Users/HASEE/Desktop/con3");//con是系统关键字，不能被创建
        try {
            if(!file.exists()) {
                boolean flag = file.createNewFile();
                System.out.println(flag?"成功":"失败");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        File file1 = new File("C:/Users/HASEE/Desktop/aa/");
        file1.mkdirs();
        System.out.println(file1.length());
        file1.delete();
    }
}
