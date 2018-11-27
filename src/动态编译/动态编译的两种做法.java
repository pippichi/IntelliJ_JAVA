package 动态编译;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * 不明原因可以运行但无法输出
 */
public class 动态编译的两种做法 {
    public static void main(String[] args) throws IOException {
        Runtime run = Runtime.getRuntime();
        Process process = run.exec("javac D:\\IntelliJ_JAVA\\src\\Test2\\TestBinary.java");
        InputStream is = process.getInputStream();
        BufferedReader br = new BufferedReader(
                new InputStreamReader(is)
        );
        String info = "";
        while((info=br.readLine())!=null)
            System.out.println(info+",");
        is.close();
        br.close();
    }
}
