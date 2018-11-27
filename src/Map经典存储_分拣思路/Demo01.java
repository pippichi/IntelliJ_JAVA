package Map经典存储_分拣思路;

/**
 * 存储到Map中
 * key:String
 * value:自定义类型
 *
 * “分拣”思路
 * 1、为所有key创建容器
 *    之后容器中存放对应value
 * 2、第一次创建容器，并存放值value
 *    第二次之后，直接使用容器存放值
 */

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

//法一
public class Demo01 {
    public static void main(String[] args) {
        String str = "dehydrate is one of the the the most most difficult things to handle.";
        String[] strArr = str.split(" ");
        Map<String,Letter> letters = new HashMap<>();

        for(String temp:strArr){
            if(!letters.containsKey(temp)){
                letters.put(temp,new Letter());
            }
            Letter col = letters.get(temp);
            col.setCount(col.getCount()+1);
        }

        //输出map的值
        for(String key:letters.keySet()){
            System.out.println(key+"---"+letters.get(key).getCount());
        }
        //
        for(Map.Entry<String,Letter> temp:letters.entrySet()){
            System.out.println(temp.getKey()+"---"+temp.getValue().getCount());
        }
        //
        Iterator<Map.Entry<String,Letter>> iter = letters.entrySet().iterator();
        while(iter.hasNext()){
            Map.Entry<String,Letter> entry = iter.next();
            System.out.println(entry.getKey()+"---"+entry.getValue().getCount());
        }
        //
        for(Letter temp:letters.values()){
            System.out.println(temp.getCount());
        }
        //
        Set<String> keys = letters.keySet();
        for(String key:keys){
            Letter col = letters.get(key);
            System.out.println(key+"---"+col.getCount());
        }
    }
}
