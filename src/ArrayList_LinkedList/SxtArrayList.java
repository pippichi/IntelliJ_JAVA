package ArrayList_LinkedList;

import java.util.List;

public class SxtArrayList {

    private Object[] elementData;

    private int size;

    public SxtArrayList(){
        this(10);
    }
    public SxtArrayList(int initialCapacity){
        if(initialCapacity<0){
            try{
                throw new Exception();
            }catch(Exception e){
                e.printStackTrace();
            }
        }
        elementData = new Object[initialCapacity];
    }
    public void checkCapacity(){
        if(size==elementData.length){
            Object[] newArr = new Object[size*2+1];
            System.arraycopy(newArr,0,elementData,0,elementData.length);
            elementData = newArr;
        }
    }
    public void checkRange(int index){
        if(index<0||index>=size){
            try{
                throw new Exception();
            }catch(Exception e){
                e.printStackTrace();
            }
        }
    }
    public void add(Object obj){
        checkCapacity();
        elementData[size++] = obj;
    }
    public Object get(int index){
        checkRange(index);
        return elementData[index];
    }
    public void remove(int index){
        checkRange(index);
        int numMoved = size - index - 1;
        if(numMoved>0){
            System.arraycopy(elementData,index+1,elementData,index,numMoved);
        }
        size--;
    }
    public boolean remove(Object obj){
        if(obj == null){
            for(int index=0;index<size;index++){
                if(elementData[index]==null){
                    remove(index);
                    return true;
                }
            }
        }else{
            for(int index=0;index<size;index++){
                if (obj.equals(elementData[index])){
                    remove(index);
                    return true;
                }
            }
        }
        return false;
    }
    public Object set(int index,Object obj){
        checkRange(index);
        Object oldValue = elementData[index];
        elementData[index] = obj;
        return oldValue;
    }
    public void add(int index,Object obj){
        checkRange(index);
        checkCapacity();
        System.arraycopy(elementData,index,elementData,index+1,size-index);
        elementData[index] = obj;
        size++;
    }
}