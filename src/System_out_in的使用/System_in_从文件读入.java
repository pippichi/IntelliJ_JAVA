package System_out_in的使用;
/**
 * ==>重定向
 * setIn()
 * setOut()
 * setErr()
 * FileDescriptor.in()
 * FileDescriptor.out();
 * FileDescriptor.err();
 */

import java.io.*;
import java.util.Scanner;

/**
 * System.in就是InputStream的一个实例
 */
public class System_in_从文件读入 {
    public static void main(String[] args) throws FileNotFoundException {
        InputStream is = System.in;//键盘输入
        is = new BufferedInputStream(new FileInputStream("D:/Java test/test/Ball.java"));
        Scanner input = new Scanner(is);
        System.out.println(input.nextLine());
        //重定向
        System.setOut(new PrintStream(new BufferedOutputStream(new FileOutputStream(new File("D:/Java test/test/test1.txt"),true)),true));
        System.out.println("继续努力");//控制台->文件
        //回控制台,控制台也是一个文件，其名为FileDescriptor
        System.setOut(new PrintStream(new BufferedOutputStream(new FileOutputStream(FileDescriptor.out)),true));
        System.out.println("aa");
    }
}
