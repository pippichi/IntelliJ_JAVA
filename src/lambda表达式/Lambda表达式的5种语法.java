package lambda表达式;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

public class Lambda表达式的5种语法 {
    public static void main(String[] args) {
        String[] arr = {"program", "creek", "is", "a", "java", "site"};
//1
        Arrays.sort(arr,(String m,String n)->Integer.compare(m.length(),n.length()));
        System.out.println(Arrays.toString(arr));
//2
        Arrays.sort(arr,(String m,String n)->{
            if(m.length()>n.length())
                return -1;
            else
                return 0;
        });
        System.out.println(Arrays.toString(arr));
//3
        Stream<String> stream = Stream.of(arr);
        stream.forEach(x-> System.out.println(x));
        stream.forEach(System.out::println);

//        4
//        Arrays.sort(list,Comparator.comparing(Person::getFirstName,Comparator.nullsFirst(Comparator.naturalOrder().reversed())) //见Java核心技术P242
//        .thenComparing(Person::getSalary));
    }
}
