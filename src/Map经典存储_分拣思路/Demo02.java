package Map经典存储_分拣思路;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

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

//法二
public class Demo02 {
    public static void main(String[] args) {
        String str = "dehydrate is one of the the the most most difficult things to handle.";
        String[] strArr = str.split(" ");
        Map<String,Letter> letters = new HashMap<>();
        /*for(String temp:strArr){

            if(!letters.containsKey(temp)) {
                Letter col = new Letter();
                col.setCount(1);
                letters.put(temp, col);
            }else{
                Letter col = letters.get(temp);
                col.setCount(col.getCount()+1);
            }
        }
             */
        for(String keys:strArr){
            Letter col = null;
            if((col=letters.get(keys))==null){
                col = new Letter();
                col.setCount(1);
                letters.put(keys,col);
            }else{
                col.setCount(col.getCount()+1);
            }
        }
        //
        for(String keys:strArr){
            System.out.println(keys+"---"+letters.get(keys).getCount());
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
        for(String temp:keys){
            Letter col = letters.get(temp);
            System.out.println(temp+"---"+col.getCount());
        }
    }
}
