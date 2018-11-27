package 反射;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * 应用反射的API，获取类的信息(类的名字、属性、 方法、构造器等)
 */
public class Demo03 {
    public static void main(String[] args) {
        String str = "反射1.User";

        try {
            Class clazz = Class.forName(str);

            //获得类名
            System.out.println(clazz.getName());//获得包名+类名
            System.out.println(clazz.getSimpleName());//获得类名

            //获得属性信息
            Field[] field = clazz.getFields();//只能获得public的field
            Field[] fields = clazz.getDeclaredFields();//获得所有类型的field
            Field field1 = clazz.getDeclaredField("uname");
            System.out.println(fields.length);
            System.out.println(field1);

            //获得方法信息
            Method[] methods = clazz.getDeclaredMethods();
            Method method = clazz.getDeclaredMethod("getUname",null);
            Method method1 = clazz.getDeclaredMethod("setUname",String.class);
            for(Method temp:methods){
                System.out.println("方法："+temp);
            }

            //获得构造器信息
            Constructor[] constructors = clazz.getDeclaredConstructors();
            for(Constructor temp:constructors){
                System.out.println(temp);
            }

            Constructor constructor = clazz.getDeclaredConstructor(null);
            System.out.println(constructor);

            Constructor constructor1 = clazz.getDeclaredConstructor(int.class,int.class,String.class);
            System.out.println(constructor1);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }
}
