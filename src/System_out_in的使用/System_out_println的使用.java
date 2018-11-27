package System_out_in的使用;

import java.io.*;

public class System_out_println的使用 {
    public static void main(String[] args) throws FileNotFoundException {
        System.out.println("ps");
        PrintStream ps = System.out;
        ps.println("ps");
        ps.println(false);

        //输出到文件
        File file = new File("D:/Java test/test/Ball.java");
        PrintStream ps2 = new PrintStream(new BufferedOutputStream(new FileOutputStream(file,true)));
        ps2.println("Life is so good!");
        ps2.flush();
        ps2.close();
    }
}
