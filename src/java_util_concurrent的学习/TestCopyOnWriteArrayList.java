package java_util_concurrent的学习;

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * CopyOnWriteArrayList/CopyOnWriteArraySet  :"写入并复制"
 * 注意：添加操作多时，效率低，因为每次添加时都会进行复制，开销非常的大。并发迭代操作多时可以选择。
 */
public class TestCopyOnWriteArrayList {
    public static void main(String[] args) {
        HelloThread h1 = new HelloThread();
        for (int i = 0; i < 10; i++) {
            new Thread(h1).start();
        }
    }
}
class HelloThread implements Runnable{
    //private static List<String> list = Collections.synchronizedList(new ArrayList<>());

    private static CopyOnWriteArrayList<String> list = new CopyOnWriteArrayList<>();

    static{
        list.add("AA");
        list.add("AC");
        list.add("AB");
    }
    @Override
    public void run() {
        Iterator<String> iter = list.iterator();
        while(iter.hasNext()){
            System.out.println(iter.next());
            list.add("BB");
        }
    }
}
