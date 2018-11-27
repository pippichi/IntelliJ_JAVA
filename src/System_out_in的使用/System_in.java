package System_out_in的使用;

import java.io.InputStream;
import java.util.Scanner;

public class System_in {
    public static void main(String[] args) {
        InputStream is = System.in;//键盘输入
        Scanner input = new Scanner(is);
        System.out.println(input.nextLine());
    }
}
