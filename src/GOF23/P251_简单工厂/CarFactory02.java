package GOF23.P251_简单工厂;

/**
 * 简单工厂类
 */
public class CarFactory02 {
    public static Car createAudi(){
        return new Audi();
    }
    public static Car createByd(){
        return new Byd();
    }
}
