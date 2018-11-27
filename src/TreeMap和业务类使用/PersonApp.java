package TreeMap和业务类使用;

import TreeSet和业务类使用.Person;

import java.util.Set;
import java.util.TreeMap;

public class PersonApp {
    public static void main(String[] args) {
        Person p1 = new Person("qyf", 100);
        Person p2 = new Person("qyf1", 110);
        Person p3 = new Person("qyf2", 110);
        Person p4 = new Person("qyf3", 1320);
        Person p5 = new Person("qyf4", 102);
        TreeMap<Person, String> map = new TreeMap<Person, String>(
                new java.util.Comparator<Person>() {
                    @Override
                    public int compare(Person o1, Person o2) {
                        return o1.getHandsome() - o2.getHandsome() > 0 ? 1 : o1.getHandsome() - o2.getHandsome() == 0 ? 0 : -1;
                    }
                }
        );
        map.put(p1,"q");
        map.put(p2,"q");
        map.put(p3,"q");
        map.put(p4,"q");
        map.put(p5,"q");
        map.put(p1,"y");
        /**
         * 查看键
         */
        System.out.println(map.keySet());
        Set<Person> keys = map.keySet();
        System.out.println(keys);
    }
}
