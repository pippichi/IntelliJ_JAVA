package Predicate和Consumer;

import org.junit.Test;

import java.util.function.Predicate;

public class Predicate测试 {
    @Test
    public void testPredicate(){
        Predicate<Integer> boolValue = x -> x>5;
        System.out.println(boolValue.test(1));
        System.out.println(boolValue.test(6));
    }
}
