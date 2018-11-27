package 迭代器;

import Map经典存储_分拣思路.Letter;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class HashMapIterator {
    public static void main(String[] args){
        /**
         * 第一种：普遍使用，二次取值
         */
        System.out.println("通过Map.keySet遍历key和value：");
        Map<String,String> map = new HashMap<String,String>();
        map.put("1","q");
        map.put("2","y");
        map.put("3","f");

        for(String key : map.keySet()){
            System.out.println("key = "+key+" and value = "+map.get(key));
        }

        /**
         * 第二种,Map.Entry<String,Stirng>写法很关键
         */
        System.out.println("通过Map.entrySet使用iterator遍历key和value：");
        Iterator<Map.Entry<String,String>> iter = map.entrySet().iterator();
        while(iter.hasNext()){
            Map.Entry<String,String> entry = iter.next();
            System.out.println("key = "+entry.getKey()+" and value = "+entry.getValue());
        }

        /**
         * 第三种：推荐，尤其是容量大时
         */
        System.out.println("通过Map.entrySet遍历key和value：");
        for(Map.Entry<String,String> entry:map.entrySet()){
            System.out.println("key = "+entry.getKey()+" and value = "+entry.getValue());
        }

        /**
         * 第四种
         */
        System.out.println("通过Map.values遍历所有的value，但不能遍历key");
        for(String value:map.values()){
            System.out.println("value = "+value);
        }
    }
}
