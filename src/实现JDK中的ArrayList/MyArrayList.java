package 实现JDK中的ArrayList;

import java.util.ArrayList;

public class MyArrayList {
    private Object[] value;

    private int size;

    public int getSize(){
        return size;
    }

    public boolean isEmpty(){
        return size==0;
    }

    public boolean contains(Object o){
        return indexOf(o) >= 0;
    }

    public int indexOf(Object o){
        if(o == null){
            for(int i=0;i<size;i++){
                if(value[i]==null){
                    return i;
                }
            }
        }else {
            for (int i = 0; i < size; i++) {
                if (o.equals(value[i])) {
                    return i;
                }
            }
        }return -1;
    }

    public int lastIndexOf(Object o){
        if(o==null){
            for(int i=0;i<size;i++){
                if(value[i]==null){
                    return i;
                }
            }
        }else{
            for(int i=size-1;i>=0;i--){
                if(o.equals(value[i])){
                    return i;
                }
            }
        }return -1;
    }

    public Object set(int index,Object obj){
        rangeCheck(index);
        Object old = value[index];
        value[index] = obj;
        return old;
    }

    public void rangeCheck(int index){
        if(index<0||index>size-1){
            try{                    //手动抛出异常
                throw new Exception();
            }catch(Exception e){
                e.printStackTrace();
            }
        }
    }

    public MyArrayList(){
        this(10);
    }
    public MyArrayList(int size){
        if(size<0){
            try{
                throw new Exception();
            }catch(Exception e){
                e.printStackTrace();
            }
        }
        value = new Object[size];
    }

    public void add(Object obj){
        value[size] = obj;
        size++;
        if(size>value.length-1){
            //装不下了
            int newSize = size * 2 + 2;
            Object[] newValue = new Object[newSize];
            for(int i=0;i<value.length;i++){
                newValue[i] = value[i];
            }
            value = newValue;
        }
    }
    public Object get(int index){
        rangeCheck(index);
        return value[index];
    }

    public static void main(String[] args){
        MyArrayList list = new MyArrayList(2);
        list.add("aaaa");
        list.add(new Test());
        list.add(new Test("a",1));
        Test t = (Test)list.get(1);

        System.out.println(list.get(2));
        System.out.println(list.getSize());
    }
}
