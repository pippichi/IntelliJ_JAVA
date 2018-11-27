package 自定义泛型_深入_无多态;

/**
 *
 */
public class FruitApp {
    public static void main(String[] args){
        Fruit f = new Apple();
        test(new Apple());
    }
    public static void test(Fruit f){

    }
    public static Fruit test(){
        return new Apple();
    }
}
