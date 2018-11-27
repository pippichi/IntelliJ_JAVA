package 反射;

import 反射1.User;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 通过反射API的动态的操作：构造器、方法、属性
 */
public class Demo04 {
    public static void main(String[] args) {
        String str = "反射1.User";

        try {
            Class<?> clazz = Class.forName(str);

            //通过反射API调用构造方法，构造对象
            User o = (User) clazz.getDeclaredConstructor(int.class,int.class,String.class).newInstance(1001,18,"qyf");//实现User的有参构造
            System.out.println(o.getUname());

            //通过API调用普通方法
            User u = (User) clazz.getDeclaredConstructor().newInstance();//调用无参构造
            //u.setUname("qyf");
            Method method = clazz.getDeclaredMethod("setUname",String.class);
            method.invoke(u,"qyf");
            System.out.println(u.getUname());

            //通过反射API操作属性
            User u1 = (User)clazz.getDeclaredConstructor().newInstance();
            Field f = clazz.getDeclaredField("uname");
            f.setAccessible(true);//这个属性不需要做安全检查了，可以直接访问
            f.set(u1,"qq");     //通过反射直接写属性
            System.out.println(u1.getUname());//直接调用
            System.out.println(f.get(u1));//通过反射调用，直接读属性
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
    }
}
