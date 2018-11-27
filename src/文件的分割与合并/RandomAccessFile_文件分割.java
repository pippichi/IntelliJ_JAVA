package 文件的分割与合并;

import java.io.*;

public class RandomAccessFile_文件分割 {
    public static void main(String[] args) throws IOException {
        RandomAccessFile raf = new RandomAccessFile(new File("D:/Java test/test/Ball1.java"),"r");
        raf.seek(11);
        byte[] temp = new byte[1024];
        int len = 0;
        while((len=raf.read(temp))!=-1){
            if(len>20){
                System.out.println(new String(temp,0,20));
                break;
            }else{
                System.out.println(new String(temp,0,len));
            }
        }
        raf.close();
    }
}
