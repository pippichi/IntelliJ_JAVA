package 强_软_弱_虚_引用的使用;

import java.lang.ref.WeakReference;

/**
 * 引用分为：强、软、弱、虚
 * 强与弱引用
 */
public class RefDemo {
    public static void main(String[] args) {
        //调用强引用方法
        testStrong();
        //弱引用管理对象
        String str = new String ("qyf is OK!");
        WeakReference<String> wr = new WeakReference<>(str);
        System.out.println("gc运行前： "+wr.get());
        str = null;
        System.gc();
        System.runFinalization();//强制调用已经失去引用的对象的finalize方法
        System.out.println("gc运行后： "+wr.get());
    }
    public static void testStrong(){
        //字符串常量值，共享，不能回收
        String str = "qyf is OK!";
        WeakReference<String> wr = new WeakReference<>(str);
        System.out.println("gc运行前： "+wr.get());
        str = null;
        System.gc();
        System.runFinalization();//强制调用已经失去引用的对象的finalize方法
        System.out.println("gc运行后： "+wr.get());
    }
}
