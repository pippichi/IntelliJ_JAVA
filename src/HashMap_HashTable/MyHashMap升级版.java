package HashMap_HashTable;

import java.util.LinkedList;

public class MyHashMap升级版 {
    LinkedList[] arr = new LinkedList[900];
    int size;
    public void put(Object key,Object value){
        MyEntry e = new MyEntry(key,value);
        int hash = key.hashCode();
        hash = hash>0?hash:-hash;
        int a = hash%arr.length;
        if(arr[a]==null){
            LinkedList list = new LinkedList();
            list.add(e);
            arr[a] = list;
        }else{
            for(int i=0;i<arr[a].size();i++){
                MyEntry e1 = (MyEntry)arr[a].get(i);
                if(e1.key.equals(key)) {
                    e1.value = value;
                }
            }
            arr[a].add(e);
        }
        size++;
    }
    public Object get(Object key){
        int a = key.hashCode()%900;
        if(arr[a]!=null){
            LinkedList list = arr[a];
            for(int i=0;i<list.size();i++){
                MyEntry e = (MyEntry)list.get(i);
                if(e.key.equals(key)){
                    return e.value;
                }
            }
        }
        return null;
    }
    public static void main(String[] args){
        MyHashMap升级版 map = new MyHashMap升级版();
        map.put("qyf","we");
        map.put("qyf","sd");
        map.put("qyf","weo");
        map.put(132,"sd");
        //map.remove("qyf");
        //map.remove("qug");
        System.out.println(map.size);
        System.out.println(map.get("qyf"));
    }
}
