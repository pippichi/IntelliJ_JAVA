package SynchronizedXxx_线程安全;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 使用Collections管理同步容器
 *  synchronizedList()
 *  synchronizedMap()
 *  synchronizedSet()
 */
public class Demo01 {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");
        list.add("c");
        List<String> synList = Collections.synchronizedList(list);
        System.out.println("线程安全的List制作完毕："+synList);
    }
}
