package Enumeration枚举vector;

import java.util.Enumeration;
import java.util.Vector;

public class Demo01 {
    public static void main(String[] args) {
        Vector<String> vector = new Vector<>();
        vector.add("q3");
        vector.add("q");
        vector.add("q1");
        vector.add("q2");
        Enumeration<String> item = vector.elements();
        while(item.hasMoreElements()){
            String str = item.nextElement();
            System.out.println(str);
        }
    }
}
