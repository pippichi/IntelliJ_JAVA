package 强_软_弱_虚_引用的使用;

import java.util.WeakHashMap;

/**
 * WeakHashMap键为弱类型，gc运行立即回收
 */
public class weakHashMapDemo {
    public static void main(String[] args) {
        WeakHashMap<String,String> map = new WeakHashMap<>();
        //测试数据
        //常量池对象，不会被回收
        map.put("a","test");
        map.put("b","tes1t");
        //gc运行时已回收
        map.put(new String("c"),"tes2t");
        map.put(new String("d"),"tes3t");
        map.put(new String("e"),"test4");
        System.gc();
        System.runFinalization();
        System.out.println(map.size());
    }
}
