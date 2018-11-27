package 反射;

import BallGame1.BallGame1;

import java.lang.reflect.InvocationTargetException;

/**
 * 创建实例 调用空构造
 *
 * 使用的时候创建对象，动态创建对象
 *
 */
public class Demo02 {

    /**
     * @param args
     */
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Class<?> clz = Class.forName("BallGame1.BallGame1");
        Object b = clz.getDeclaredConstructor().newInstance();
    }
}
