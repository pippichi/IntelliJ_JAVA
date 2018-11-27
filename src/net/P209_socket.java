package net;

import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.UnknownHostException;

public class P209_socket {
    public static void main(String[] args) {
        InetSocketAddress address = new InetSocketAddress("localhost",9999);
        try {
            address = new InetSocketAddress(InetAddress.getByName("localhost"),9999);
            System.out.println(address.getHostName());
            System.out.println(address.getPort());
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        InetAddress addr = address.getAddress();
        System.out.println(addr.getHostAddress()); //返回:地址
        System.out.println(addr.getHostName()); //输出计算机名
    }
}
