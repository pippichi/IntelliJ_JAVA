package Comparator接口;

import java.util.*;

/**
 * 排序规则的业务类
 *
 */
public class Demo01{
    public static <T>void sort(List<T> list,Comparator<T> com){
        Object[] arr = list.toArray();
        sort(arr,com);
        for(int i=0;i<arr.length;i++){
            list.set(i,(T)arr[i]);
        }
    }

    public static <T>void sort(Object[] value,Comparator<T> com){
        Object temp;
        for(int i=0;i<value.length-1;i++){
            boolean sorted = true;
            for(int j=0;j<value.length-1-i;j++){
                if(com.compare((T)value[i],(T)value[i+1])>0){
                    temp = value[j];
                    value[j] = value[j+1];
                    value[j+1] = temp;
                    sorted = false;
                }
            }
            if(sorted){
                break;
            }
        }
    }

    public static <T>void main(String[] args) {
        List<Integer> a = new ArrayList<>();
        a.add(2);
        a.add(21);
        a.add(4);
        a.add(8);
        a.add(6);
        a.add(22);
        Demo01.sort(a,new Util());
        System.out.println(a);
    }
}
