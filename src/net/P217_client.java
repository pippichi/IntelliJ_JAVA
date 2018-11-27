package net;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.Socket;

/**
 * 创建客户端:发送数据+接收数据
 * 写出数据:输出流
 * 读取数据:输入流
 *
 * 输入流和输出流在同一个线程内 应该独立处理，彼此独立
 *
 * 加入名称
 */
public class P217_client {
    public static void main(String[] args) throws IOException {
        System.out.println("请输入名称:");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String name = br.readLine();
        if(name==null&&name.equals(""))
            return;
        Socket client = new Socket(InetAddress.getByName("localhost"),9999);
        //控制台输入流
        new Thread(new P217_Send(client,name)).start();//一条路径
        new Thread(new P217_Receive(client)).start();//另一条路径
    }
}
