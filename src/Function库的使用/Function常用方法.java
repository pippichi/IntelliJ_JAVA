package Function库的使用;

import java.util.function.Function;

public class Function常用方法 {
    private static String hello = "Nice to meet you";
    private static String name1 = "my name is huohuo";

    public static void main(String[] args) {
        Function<Integer,Integer> name = e->e*2;
        Function<Integer,Integer> square = e->e*e;
        int value = name.andThen(square).apply(3);
        System.out.println("andThen value:"+value);
        int value2 = name.compose(square).apply(3);
        System.out.println("compose value:"+value2);
        //返回一个执行了apply()方法之后只会返回输入参数的函数对象
        Object identity = Function.identity().apply("huohuo");
        System.out.println(identity);

//        apply基本应用
        //字符串长度记录返回
        MyFunction myFunction = new MyFunction();
        MyBiFunction myBiFunction = new MyBiFunction();
        int num = myFunction.apply(hello);
        String valueBi = myBiFunction.apply(hello,name1);
        //hello长度返回
        System.out.println(num);
        //语句整合返回
        System.out.println(valueBi);
    }
}
