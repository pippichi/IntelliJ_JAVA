package net;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;

/**
 * 创建客户端:发送数据+接收数据
 * 写出数据:输出流
 * 读取数据:输入流
 *
 * 输入流和输出流在同一个线程内 应该独立处理，彼此独立
 */
public class P216_client {
    public static void main(String[] args) throws IOException {
        Socket client = new Socket(InetAddress.getByName("localhost"),9999);
        //控制台输入流
        new Thread(new P216_Send(client)).start();//一条路径
        new Thread(new P216_Receive(client)).start();//另一条路径
    }
}
