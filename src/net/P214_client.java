package net;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;

/**
 * 创建客户端:发送数据+接收数据
 * 写出数据:输出流
 * 读取数据:输入流
 *
 * 输入流和输出流在同一个线程内 应该独立处理，彼此独立
 */
public class P214_client {
    public static void main(String[] args) throws IOException {
        Socket client = new Socket(InetAddress.getByName("localhost"),9999);
        //控制台输入流
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        DataInputStream dis = new DataInputStream(client.getInputStream());
        DataOutputStream dos = new DataOutputStream(client.getOutputStream());
        while(true) {
            String info = br.readLine();
            //输出
            dos.writeUTF(info);
            dos.flush();
            //输入
            String msg = dis.readUTF();
            System.out.println(msg);
        }
    }
}
