package net;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

/**
 * 1、创建客户端 必须指定服务器+端口 此时就在连接
 *      Socket(String host,int port)
 * 2、接收数据+发送数据
 */
public class P213_TCP_client {
    public static void main(String[] args) throws IOException {
        //1、创建客户端 必须指定服务器+端口 此时就在连接
        Socket socket = new Socket("localhost",8888);
        //2、接收数据
//        BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
//        String echo = br.readLine(); //阻塞式方法
//        System.out.println(echo);
        DataInputStream dis = new DataInputStream(socket.getInputStream());
        String echo = dis.readUTF();
        System.out.println(echo);
    }
}
