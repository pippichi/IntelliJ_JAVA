package 反射;

/**
 * 测试java.lang.Class对象的获取方式
 */
public class Demo {
    public static void main(String[] args) {
        String str = "反射1.User";

        try {
            Class<?> clazz = Class.forName(str);//一个类只对应一个反射对象
            System.out.println(clazz.hashCode());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
