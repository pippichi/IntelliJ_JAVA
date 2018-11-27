package HashMap_HashTable;

import java.util.HashMap;
import java.util.Map;

public class TestHashMap {
    public static void main(String[] args){
        Map map = new HashMap();
        map.put("qyf",new Wife("xscn"));
        map.put("x7",new Wife("x7"));

        Wife w = (Wife)map.get("qyf");
        map.remove("x7");
        map.clear();
        System.out.println(w.name);
    }
}
class Wife{
    String name;
    public Wife(String name){
        this.name = name;
    }
}
