package 迭代器;

import java.util.*;

public class TestIterator {
    public static void main(String[] args){
        Set set = new HashSet();
        set.add("q");
        set.add("y");
        set.add("f");
        /*迭代器用法一：
        Iterator iter = set.iterator();
        while(iter.hasNext()){
            String str = (String)iter.next();
            System.out.println(str);
        }*/
        //法二：
        for(Iterator iter = set.iterator();iter.hasNext();){
            String str = (String)iter.next();
            System.out.println(str);
        }
        List list = new ArrayList();
        list.add("q");
        list.add("y");
        list.add("f");

        for(Iterator iter = list.iterator();iter.hasNext();){
            String str = (String) iter.next();
            System.out.println(str);
            iter.remove();
        }
        System.out.println(list.size());
    }
}
