package io.file;

import java.io.*;

public class 处理流_将信息输出到字节数组 {
    public static void main(String[] args) throws IOException {
        System.out.println(write().length);
        read(write());
    }


    public static byte[] write() throws IOException {
        byte[] aim = null;
        double s1 = 20.1;
        Long s2 = 2131L;
        String s3 = "数据类型";
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        DataOutputStream dos = new DataOutputStream(
                new BufferedOutputStream(
                        bos
                )
        );
        dos.writeDouble(s1);
        dos.writeLong(s2);
        dos.writeUTF(s3);
        dos.flush();
        aim = bos.toByteArray();
        dos.close();

        return aim;
    }

    public static void read(byte[] bytes) throws IOException {
        ByteArrayInputStream bis = new ByteArrayInputStream(bytes);
        DataInputStream dis = new DataInputStream(
                new BufferedInputStream(
                        bis
                )
        );
        double s1 = dis.readDouble();
        long s2 = dis.readLong();
        String s3 = dis.readUTF();
        System.out.println(s1+"\n"+s2+"\n"+s3+"\n");
        if(dis!=null){
            dis.close();
        }
        if(bis!=null){
            bis.close();
        }
    }
}
