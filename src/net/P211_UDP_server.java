package net;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

/**
 *服务端
 * 1、创建服务端+端口
 * 2、准备接受容器
 * 3、封装成包
 * 4、接受数据
 * 5、分析数据
 * 6、释放
 */
public class P211_UDP_server {
    /**
     *
     */
    public static void main(String[] args) throws IOException {
        //1、创建服务端+端口
        DatagramSocket server = new DatagramSocket(8888);
        //2、准备接受容器
        byte[] container = new byte[1024];
        //3、封装成包DatagramPacket(byte[] buf,int length)
        DatagramPacket packet = new DatagramPacket(container,container.length);
        //4、接受数据
        server.receive(packet);
        byte[] data = packet.getData();
        //5、分析数据
        int len = packet.getLength();
        System.out.println(new String(data,0,len));
        //6、释放
        server.close();
    }
}
