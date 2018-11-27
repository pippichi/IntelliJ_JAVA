package 自定义泛型_深入_无多态;

/**
 * 泛型没有多态
 * 泛型没有数组
 */
public class App {
    public static void main(String[] args){
        //A<Fruit> a = new A<Apple>(); 错！！泛型没有多态
        A<Fruit> f = new A<Fruit>();
        //test(new A<Apple>());
    }
    public static void test(A<Fruit> f){

    }
    public static A<Fruit> test2(){
        //return (A<Fruit>)(new A<Apple>());
        return null;
    }
}
