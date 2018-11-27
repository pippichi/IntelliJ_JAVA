package io.file;

import java.io.*;

public class 拷贝文件_输入和输出一起使用 {
    public static void copyFile(String src,String tgt) throws IOException {
        //1、建立联系 源文件(存在且为文件)+目的地(文件可以不存在)
        copyFile(new File(src),new File(tgt));
    }

    public static void copyFile(File source,File target) throws IOException {
        if(!source.isFile()){
            System.out.println("只能拷贝文件");
            throw new IOException("只能拷贝文件");
        }
        if(target.isDirectory()){
            System.out.println(target.getAbsolutePath()+"不能创建与已有文件夹同名的文件");
            throw new IOException(target.getAbsolutePath()+"不能创建与已有文件夹同名的文件");
        }
        InputStream is = null;
        OutputStream os = null;
        is = new FileInputStream(source);
        os = new FileOutputStream(target,true);
        byte[] bytes = new byte[1024];
        int len = 0;
        while((len=is.read(bytes))!=-1){
            os.write(bytes,0,len);
        }
        os.flush();
        //这里is/os不可能为空，因此不需要判断空方法，直接关闭即可
        //先打开的后关闭
        os.close();
        is.close();
    }

    public static void main(String[] args) {
        String s1 = "D:/Java test/test/test1.txt";
        String s2 = "D:/Java test/test/test4.txt";
        try {
            copyFile(s1,s2);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("拷贝源文件不存在|拷贝文件失败|关闭流失败");
        }
    }
}
