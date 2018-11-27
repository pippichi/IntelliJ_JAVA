package GOF23.P251_简单工厂;

/**
 * 测试在没有工厂模式的情况下
 */
public class client01 {
    public static void main(String[] args) {
        Car c1 = new Audi();
        Car c2 = new Byd();


    }
}
