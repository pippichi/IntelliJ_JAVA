package JVM_测试类加载全过程;

/**
 * 自定义加密解密加载器
 */
public class P246 {
//    00000011
//    11111111
//    ---------
//    11111100
    public static void main(String[] args) {
        int a = 3;//00000011
        System.out.println(Integer.toBinaryString(a^0xff));//异或操作
    }
}
