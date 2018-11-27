package HashSet;

import HashMap_HashTable.MyHashMap;

import java.util.HashMap;

public class MyHashSet {
    HashMap map;
    private static final Object PERSENT = new Object();

    public MyHashSet(){
        map = new HashMap();
    }
    public void add(Object o){
        map.put(o,PERSENT);
    }
    public void remove(){}
    public int getSize(){
        return map.size();
    }
}
