package io.file;

import java.io.*;

public class 写入文件 {
    public static void main(String[] args) {
        File file = new File("D:/Java test/test/test2.txt");
        OutputStream os = null;
        try {
            //以append形式写入信息,则写true;覆盖则写false
            os = new FileOutputStream(file,false);
            String str = "你瞒着所有人在爱谁？---大酒神 \r\n";
            byte[] data = str.getBytes();
            os.write(data,0,data.length);
            os.flush();//强制刷新出去

        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("找不到文件");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("文件写入失败");
        }finally{
            if(os!=null){
                try {
                    os.close();
                } catch (IOException e) {
                    e.printStackTrace();
                    System.out.println("输出流关闭失败");
                }
            }
        }
    }
}
