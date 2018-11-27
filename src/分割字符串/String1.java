package 分割字符串;

import java.util.StringTokenizer;

/**
 * StringTokenizer不支持正则表达式
 */
public class String1 {
    public static void main(String[] args){
        String str = "192.168.1.1";
        StringTokenizer stringTokenizer = new StringTokenizer(str,".");
        while(stringTokenizer.hasMoreElements()){
            System.out.println(stringTokenizer.nextToken());
        }

        String[] str1 = str.split("\\.",3);
        for(int i=0;i<str1.length;i++){
            System.out.println(str1[i]);
        }
        String str2 = "             2132131   ";
        str2 = str2.substring(0,str2.length()-1).trim();
        System.out.println(str2);
    }
}