package 重写泛型_泛型擦除;

import java.io.Closeable;
import java.io.IOException;

public class 泛型方法 {
    /**
     * 泛型方法
     * 只能访问对象信息，不能修改信息
     * @param a
     * @param <T>
     */
    public static <T> void test(T a){
        System.out.println(a);
    }
    public static <T extends Closeable> void test(T... a) throws IOException {
        for(T temp:a){
            if(temp!=null){
                temp.close();
            }
        }
    }
    public static void main(String[] args){
        test("1");
    }
}
