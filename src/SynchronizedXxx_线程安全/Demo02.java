package SynchronizedXxx_线程安全;

import java.util.*;

/**
 * 只读设置
 * 1、emptyXxx() 空的不可变的集合 比如避免空指针异常
 *      emptyList()
 *      emptyMap()
 *      emptySet()
 * 2、singletonXxx() 一个元素不可变的集合 只包含一个元素，不能加入更多的元素
 *      singleton(T o)
 *      singletonList(T o)
 *      singletonMap(T o)
 * 3、unmodifiableXxx() 不可变容器
 *      unmodifiableList(List<? extends T> list)
 *      unmodifiableSet(Set<? extends T> set)
 *      unmodifiableMap(Map<? extends K,? extends V> map)
 */
public class Demo02 {
    public static void main(String[] args) {
        Map<String,String> map = new HashMap<>();
        map.put("a","test");
        map.put("b","test2");
        Map<String,String> map2 = Collections.unmodifiableMap(map);
        //map2.put("s","sd");    不能操作
        System.out.println(map2.size());

        //一个元素的容器测试
        List<String> list = Collections.singletonList(new String("ds"));
        //list.add("c");
        System.out.println(list);
    }

    public static Set<String> oper(Set<String> set){
        if(set == null){
            return Collections.EMPTY_SET;//这样就无需处理空指针问题了
        }
        return set;
    }
}
