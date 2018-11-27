package net;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class P209_ip {
    public static void main(String[] args) throws UnknownHostException {
        //使用getLocalHost方法创建InetAddress对象
        InetAddress addr = InetAddress.getLocalHost();  //返回:192.168.93.1
        System.out.println(addr.getHostAddress()); //输出计算机名
        //根据域名得到InetAddress对象
        addr = InetAddress.getByName("www.bilibili.com");
        System.out.println(addr.getHostAddress()); //返回bilibili服务器的ip
        System.out.println(addr.getHostName()); //得到www.bilibili.com
        //根据ip得到InetAdderss对象
        addr = InetAddress.getByName("61.135.253.15");
        System.out.println(addr.getHostAddress()); //返回163服务器的ip
        System.out.println(addr.getHostName());
    }
}
