package lambda表达式;

import java.io.File;
import java.io.FileFilter;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.LongStream;

public class lambdaTest {
    public static void main(String[] args) {
        test1();
        test2();
        test3();
        test4();
        test5();
        test6();
    }

    public static void test1(){
        new Thread(new Runnable(){
            @Override
            public void run(){
                System.out.println("The old runnable is running");
            }
        }).start();

        new Thread(()-> System.out.println("The new runnable is running")).start();
    }

    public static void test2(){
        List<String> names = Arrays.asList("qyf","java","python","javaScript");
        names.forEach(x-> System.out.println(x));//遍历方法一
        names.forEach(System.out::println);//遍历方法二
    }

    /**
     * lambda 实现map
     */
    public static void test3(){
        List<Integer> lists = Arrays.asList(1,2,10,2);
        lists.stream().map(x->x+x*2).forEach(System.out::println);
        lists.forEach(x-> System.out.println(x));
    }
    public static void test4(){
        List<Integer> lists = Arrays.asList(10,20,30);
        double result = lists.stream().map(x->x+x*0.05).reduce((sum,x)->sum+x).get();
        System.out.println(result);
    }
    public static void test5(){
        List<Integer> lists = Arrays.asList(1,2,3,4,5);
        double result = lists.stream().reduce((sum,x1)->sum+x1).get();
        double result2 = lists.stream().map(x->x+x*2).reduce((count,x)->count+x).get();
        System.out.println(result);
        System.out.println(result2);
    }
    public static void test6(){
        List<Integer> lists = Arrays.asList(1,2,3,4,5);
        List<Integer> list = lists.stream().filter(x->x>=2).collect(Collectors.toList());
        System.out.println(list);
    }
    public static void test7(){
        FileFilter f = (File x)->x.getName().endsWith(".java");
    }
}