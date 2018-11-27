package Collections的使用;

import Comparator接口.Util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Vector;

public class Demo01 {
    public static <T>void main(String[] args) {
        List<Integer> a = new ArrayList<>();
        a.add(2);
        a.add(21);
        a.add(4);
        a.add(8);
        a.add(6);
        a.add(22);
        Collections.sort(a,new Util());
        System.out.println(a);
        Collections.sort(a);
        System.out.println(a);
        Collections.reverse(a);
        System.out.println(a);
        Collections.shuffle(a);
        System.out.println(a);
    }
}
