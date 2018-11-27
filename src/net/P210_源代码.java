package net;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;

public class P210_源代码 {
    public static void main(String[] args) throws IOException {
        URL url = new URL("http://www.baidu.com");//主页默认资源

//        //获取资源网络流
//        InputStream is = url.openStream();
//        byte[] flush = new byte[1024];
//        int len = 0;
//        while(-1!=(len=is.read(flush))){
//            System.out.println(new String(flush,0,len));
//        }
//        is.close();
        //获取资源网络流
        BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream(),"utf-8"));

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(new File("baidu.html"),false),"utf-8"));

        String msg = null;
        while((msg=br.readLine())!=null){
            System.out.println(msg);
            bw.append(msg);
            bw.newLine();
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
