package 迭代器;

import java.util.Iterator;

/**
 * 简化迭代器原理，加入接口提供方法
 * hasNext
 * next
 */

public class MyArrayList2 implements java.lang.Iterable<String>{
    private String[] elem = {"a","b","c","d","e","f"};
    private int size = elem.length;

    /*private class Myit implements Iterator<String> {
        private int cursor = -1;

        public boolean hasNext() {
            return cursor + 1 < size;
        }

        public String next() {
            cursor++;
            return elem[cursor];
        }

        public void remove() {

        }
    }*/

    /**
     * 匿名内部类
     * @return
     */
    public Iterator<String> iterator(){
        return new Iterator<String>() {
            private int cursor = -1;

            public boolean hasNext() {
                return cursor + 1 < size;
            }

            public String next() {
                cursor++;
                return elem[cursor];
            }

            public void remove() {

            }
        };
    }

    public static void main(String[] args){
        MyArrayList2 list = new MyArrayList2();
        Iterator<String> it = list.iterator();
        while(it.hasNext()){
            String str = it.next();
            System.out.println(str);
            it.remove();//可以在查看的时候删除元素
        }
        System.out.println("增强for，必须实现java.lang.Iterable接口，重写iterator方法");
        for(String temp:list){
            System.out.println(temp);
        }
    }
}
