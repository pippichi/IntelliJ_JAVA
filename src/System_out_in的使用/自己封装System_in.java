package System_out_in的使用;

import java.io.*;

/**
 * 封装输入
 */
public class 自己封装System_in {
    public static void main(String[] args) throws IOException {
        InputStream is = System.in;
        BufferedReader br = new BufferedReader(new InputStreamReader(is));
        System.out.println("请输入：");
        String str = br.readLine();
        System.out.println(str);
    }
}
