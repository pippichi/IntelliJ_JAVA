package lambda表达式;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class lambda和Predicate组合 {
    public static void filterTest(List<String> list, Predicate<String> predicate){
        list.stream().filter(x->predicate.test(x)).forEach(x-> System.out.println(x+ " "));
    }

    public static void main(String[] args) {
        List<String> list = Arrays.asList("Java","python","c++","javaScript");
        filterTest(list,x->x.startsWith("j"));
        filterTest(list,x->x.endsWith("+"));
        filterTest(list,x->true);
        filterTest(list,x->false);
        filterTest(list,x->x.startsWith("J"));
        filterTest(list,x->x.length()>4);
    }
}
