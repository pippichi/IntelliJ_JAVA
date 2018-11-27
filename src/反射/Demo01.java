package 反射;

/**
 * 获取结构信息Class对象(源头)，有了源头就可以创建实例
 * 测试各种类型(class,interface,enum,annotation,primitive,type,void等)java.lang.Class对象的获取方式
 */
public class Demo01 {
    public static void main(String[] args) throws ClassNotFoundException {
        String str = "abxc";
        //Class对象
        //对象.getClass()
        Class<?> clz = str.getClass();
        //类.class
        clz = String.class;
        //完整路径
        clz = Class.forName("java.lang.String");

        Class intClazz = int.class;
        System.out.println(intClazz);

        int[] arr01 = new int[10];
        int[] arr02 = new int[30];
        int[][] arr03 = new int[20][3];
        System.out.println(arr01.getClass().hashCode());
        System.out.println(arr02.getClass().hashCode());
        System.out.println(arr03.getClass().hashCode());
    }
}
