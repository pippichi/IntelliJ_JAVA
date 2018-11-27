package HashMap_HashTable;


public class MyHashMap {

    MyEntry[] arr = new MyEntry[100];
    int size = 0;

    public void put(Object key,Object value){
        MyEntry e = new MyEntry(key,value);
        arr[size++] = e;
    }
    public Object get(Object key){
        for(int i=0;i<size;i++){
            if(arr[i].key.equals(key)){
                return arr[i].value;
            }
        }
        return null;
    }
    private void remove(int index){
        int numMoved = size - index - 1;
        System.arraycopy(arr,index+1,arr,index,numMoved);
        size--;
    }
    public boolean remove(Object obj){
        if(obj==null){
            for(int i=0;i<size;i++){
                if(arr[i]==null){
                    remove(i);
                    return true;
                }
            }
        }else{
            for(int i=0;i<size;i++) {
                if (arr[i].key.equals(obj)) {
                    remove(i);
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args){
        MyHashMap map = new MyHashMap();
        map.put("qug","we");
        map.put("qyf","sd");
        map.put(132,"sd");
        map.remove("qyf");
        map.remove("qug");
        System.out.println(map.size);
        System.out.println(map.get("qyf"));
    }
}
class MyEntry{
    Object key;
    Object value;

    public MyEntry(Object key,Object value){
        super();
        this.key = key;
        this.value = value;
    }
}
