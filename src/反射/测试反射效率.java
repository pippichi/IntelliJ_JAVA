package 反射;

import 反射1.User;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class 测试反射效率 {
    public static void test01(){
        User u = new User();

        long startTime = System.currentTimeMillis();

        for(int i=0;i<1000000000L;i++){
            u.getUname();
        }

        long endTime = System.currentTimeMillis();
        System.out.println("普通方法调用，执行10亿次，耗时："+(endTime-startTime)+"ms");
    }

    public static void test02() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        User u = new User();
        Class clazz = u.getClass();
        Method m = clazz.getDeclaredMethod("getUname",null);
        //m.setAccessible(true);

        long startTime = System.currentTimeMillis();

        for(int i=0;i<1000000000L;i++){
            m.invoke(u,null);
        }

        long endTime = System.currentTimeMillis();
        System.out.println("反射动态方法调用，执行10亿次，耗时："+(endTime-startTime)+"ms");
    }

    public static void test03() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        User u = new User();

        Class clazz = u.getClass();

        Method m = clazz.getDeclaredMethod("getUname");
        m.setAccessible(true);

        long startTime = System.currentTimeMillis();

        for(int i=0;i<1000000000L;i++){
            m.invoke(u,null);
        }

        long endTime = System.currentTimeMillis();
        System.out.println("反射动态方法调用，跳过安全检查，执行10亿次，耗时："+(endTime-startTime)+"ms");
    }

    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        test01();
        test02();
        test03();
    }
}
