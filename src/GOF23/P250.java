package GOF23;

import java.io.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * 测试反射和反序列化破解单例模式
 */
public class P250 {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException, IOException {
        P250_懒汉 s1 = P250_懒汉.getInstance();
        P250_懒汉 s2 = P250_懒汉.getInstance();
        System.out.println(s1==s2);

        Class<P250_懒汉> clazz = (Class<P250_懒汉>) Class.forName("GOF23.P250_懒汉");
        Constructor<P250_懒汉> c = clazz.getDeclaredConstructor(null);
        c.setAccessible(true);

//        通过在初始化构造器中报错来防止非单例
//        P250_懒汉 s3 = c.newInstance();
//        P250_懒汉 s4 = c.newInstance();
//        System.out.println(s3==s4);

        //通过反序列化的方式构造多个对象
        FileOutputStream fos = new FileOutputStream(new File("D:\\IntelliJ_JAVA\\src\\GOF23\\text.txt"));
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(s1);
        oos.close();
        fos.close();

        //反序列化
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("D:\\IntelliJ_JAVA\\src\\GOF23\\text.txt"));
        P250_懒汉 s5 = (P250_懒汉) ois.readObject();
        System.out.println(s5==s1);
    }
}
