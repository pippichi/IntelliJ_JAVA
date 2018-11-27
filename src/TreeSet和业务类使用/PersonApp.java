package TreeSet和业务类使用;
import Comparator接口.Util;

import java.util.TreeSet;

/**
 * TreeSet　在添加数据时排序
 * 不要修改数据，否则可能重复
 */
public class PersonApp {

    public static void main(String[] args) {
        TreeSet<Person> persons = new TreeSet<>(
                new java.util.Comparator<Person>(){
                    @Override
                    public int compare(Person o1, Person o2){
                        return o1.getHandsome()-o2.getHandsome()>0?1:o1.getHandsome()-o2.getHandsome()==0?0:-1;
                    }
                }
        );
        addPerson(persons);
        System.out.println(persons);
    }
    public static void addPerson(TreeSet<Person>personList){
        personList.add(new Person("qyf1",100));
        personList.add(new Person("qyf1",170));
        personList.add(new Person("qyf2",60));
        personList.add(new Person("qyf3",300));
        personList.add(new Person("qyf4",202));
    }
}
