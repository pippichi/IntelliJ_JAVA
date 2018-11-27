package lambda表达式;

import java.util.concurrent.Callable;
import java.util.function.Function;
import java.util.function.UnaryOperator;

public class 什么是Lambda {
    public static void main(String[] args) throws Exception {
//        1、
        Runnable r1 = ()->{
            System.out.println("Hello Lambda");
        };
//        2、
        Object obj = (Runnable)()-> System.out.println("Hello Lambda");
//        3、
        System.out.println((Runnable)()-> System.out.println("Hello Lambda"));
//        4、
        // 统计年龄在25-35岁的男女人数、比例
         /*public void boysAndGirls(List<Person> persons) {
            Map<Integer, Integer> result = persons.parallelStream().filter(p -> p.getAge()>=25 && p.getAge()<=35).
                collect(
                                        Collectors.groupingBy(p->p.getSex(), Collectors.summingInt(p->1))
                                );
            System.out.print("boysAndGirls result is " + result);
            System.out.println(", ratio (male : female) is " + (float)result.get(Person.MALE)/result.get(Person.FEMALE));
        }*/
//         5、
        // 嵌套的λ表达式
        Callable<Runnable> c1 = ()->()-> System.out.println("Nested lambda");
        c1.call().run();
        // 用在条件表达式中
        Callable<Integer> c2 = true?(()->42):(()->24);
        System.out.println(c2.call());
        // 定义一个递归函数，注意须用this限定
        System.out.println(new 什么是Lambda().factorial.apply(4));
//        6、
        //捕获（Capture）
    }
    // 定义一个递归函数，注意须用this限定
    protected  UnaryOperator<Integer> factorial = i->i==0?1:i*this.factorial.apply(i-1);
    //在Java8中，内部类和λ表达式都可以访问effectively final的本地变量。
    int temp1 = 1;//包围类的成员变量
    static int temp2 = 2;//包围类的静态成员变量
    public void testCartrue(){
        int temp3 = 3;//没有声明为final,但是effectively final的本地变量
        final int temp4 = 4;//声明为final的本地变量
        int temp5 = 5;//普通本地变量

        Function<Integer,Integer> f1 = i->i+temp1;
        Function<Integer,Integer> f2 = i->i+temp2;
        Function<Integer,Integer> f3 = i->i+temp3;
        Function<Integer,Integer> f4 = i->i+temp4;
        Function<Integer,Integer> f5 = i->i+temp5;
        Function<Integer,Integer> f6 = i->{
//            temp5+=i; //编译出错！对temp5赋值导致它不是effectively final的
            return temp5;
        };

//        temp5 = 9; //编译出错！对temp5赋值导致它不是effectively final的
    }
}
