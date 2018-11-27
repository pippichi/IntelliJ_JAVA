package System_out_in的使用;

/**
 * System.err.print与System.out.print本质上无差别，都是继承与PrintStream，只是输出文字不同
 */
public class System_err {
    public static void main(String[] args) {
        System.err.println("error");
    }
}
