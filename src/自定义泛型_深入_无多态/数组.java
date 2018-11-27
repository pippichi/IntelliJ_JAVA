package 自定义泛型_深入_无多态;

import HashSet.MyHashSet;

import java.util.Arrays;

/**
 * 没有泛型数组
 * 声明可以使用，但是创建失败
 */
public class 数组 {
    public static void main(String[] args){
        Student<String>[] arr;
        //Student<String>[] arr = new Student<String>[2];
        Student<?>[] arr2 = new Student[2];
        //Student<?>[] arr2 = new Student<Object>[2];
        MyArrayList<String> arr3 = new MyArrayList<String>();
        arr3.add(0,"qyf");
        arr3.add(1,"qyf2");
        String str = arr3.getElem(1);
        System.out.println(str);
        System.out.println(Arrays.toString(arr3.getAll()));
    }
}
class MyArrayList<E>{
    Object[] cap = new Object[10];
    @SuppressWarnings("unchecked")
    public E getElem(int idx){
        return (E) cap[idx];
    }
    @SuppressWarnings("unchecked")
    public E[] getAll(){
        return (E[])cap;
    }
    public void add(int idx,E e){
        cap[idx] = e;
    }
}
