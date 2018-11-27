package 强_软_弱_虚_引用的使用;

import java.util.IdentityHashMap;

/**
 * IdentifyHashMap 键比较地址并去重
 */
public class IdentityHashMapDemo {
    public static void main(String[] args) {
        IdentityHashMap<String,String> map = new IdentityHashMap<>();
        //常量池中的a和b
        map.put("a","ab");
        map.put("a","ab");
        map.put("b","a2b");
        map.put("b","ab");

        //不是常量之中的a和b
        map.put(new String("a"),"abc");
        map.put(new String("a"),"ab");
        map.put(new String("b"),"abc");


        System.out.println(map.size());
    }
}
