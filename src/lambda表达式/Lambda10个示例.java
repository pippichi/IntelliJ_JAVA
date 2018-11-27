package lambda表达式;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Lambda10个示例 {
    public static void main(String[] args) {
        List<String> languages = Arrays.asList("Java", "Scala", "C++", "Haskell", "Lisp");
        System.out.println("Languages which starts with J :");
        filter(languages, (str) -> str.startsWith("J"));
        System.out.println("Print all languages :");
        filter(languages, (str) -> true);

//        例5、如何在lambda表达式中加入Predicate
        Predicate<String> startsWithJ = n -> n.startsWith("J");
        Predicate<String> fourLetterLong = n -> n.length() == 4;
        languages.stream()
                .filter(startsWithJ.and(fourLetterLong))
                .forEach(n -> System.out.println("nName, which starts with 'J' and four letter long is : " + n));

//        例6、Java 8中使用lambda表达式的Map和Reduce示例
        List<Integer> costBeforeTax = Arrays.asList(100, 200, 300, 400, 500);
        // 不使用lambda表达式为每个订单加上12%的税
        for (Integer cost : costBeforeTax){
            double price = cost + .12 * cost;
            System.out.println(price);
        }
        // 使用lambda表达式
        costBeforeTax.stream().map(cost->cost+cost*.12).forEach(System.out::println);
        //使用reduce 为每个订单加上12%的税
        double bill = costBeforeTax.stream().map(cost->cost+.12*cost).reduce((sum,cost)->sum+cost).get();
        System.out.println("Total : "  + bill);

//        例7、通过过滤创建一个String列表
        List<String> filtered = languages.stream().filter(x->x.length()>2).collect(Collectors.toList());
        System.out.printf("Original List : %s, filtered list : %s %n", languages, filtered);

//        例8、对列表的每个元素应用函数
        List<String> G7 = Arrays.asList("USA", "Japan", "France", "Germany", "Italy", "U.K.","Canada");
        String G7Countries = G7.stream().map(x->x.toUpperCase()).collect(Collectors.joining(","));
        System.out.println(G7Countries);

//        例9、复制不同的值，创建一个子列表
        List<Integer> numbers = Arrays.asList(9, 10, 3, 4, 7, 3, 4);
        List<Integer> distinct = numbers.stream().map(i->i*i).distinct().collect(Collectors.toList());//distinct的目的就是选出不一样的数字
        System.out.printf("Original List : %s,  Square Without duplicates : %s %n", numbers, distinct);
    }
    public static void filter(List<String> names, Predicate<String> condition){
        for(String name:names)
            if(condition.test(name))
                System.out.println(name+" ");
    }
    public static <T> void filter2(List<T> names,Predicate<T> condition){
        names.stream().filter(name->(condition.test(name))).forEach(name-> System.out.println(name +" "));
    }
}
