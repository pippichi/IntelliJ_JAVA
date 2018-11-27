package io.file;

/**
 * 转换流：字节流转为字符流  处理乱码（编码集、解码集）
 * 乱码：
 * 1）编码与解码的字符集不统一
 * 2）字节缺少，长度丢失
 *
 * 编码与解码字符集必须相同，否则乱码
 */

import java.io.UnsupportedEncodingException;

public class 字节转字符_getBytes {
    public static void main(String[] args) throws UnsupportedEncodingException {
        //解码byte->char
        String str = "中国";
        //编码char->byte
        byte[] data = str.getBytes();
        System.out.println(data);
        data = str.getBytes("utf-8");//设定编码字符集
        System.out.println(data);
        System.out.println(new String(data));

        //编码
        byte[] data2 = "中国".getBytes("utf-8");
        str = new String(data2,"utf-8");
        System.out.println(str);

        //字节数不完整
        byte[] data3 = "中国".getBytes("utf-8");
        System.out.println(new String(data3,0,4));
    }
}
