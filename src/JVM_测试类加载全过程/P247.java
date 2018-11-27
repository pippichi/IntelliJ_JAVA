package JVM_测试类加载全过程;

/**
 * 通过线程类加载器抛弃双亲委派加载链模式
 * 线程上下文类加载器测试
 */
public class P247 {
    public static void main(String[] args) throws ClassNotFoundException {
        ClassLoader loader = P247.class.getClassLoader();
        System.out.println(loader);

        ClassLoader loader1 = Thread.currentThread().getContextClassLoader();
        System.out.println(loader1);

        Thread.currentThread().setContextClassLoader(new P245("D:\\IntelliJ_JAVA\\src"));
        System.out.println(Thread.currentThread().getContextClassLoader());

        Class<?> c = Thread.currentThread().getContextClassLoader().loadClass("Ploygon_Polyline.Display");
        System.out.println(c);
        System.out.println(c.getClassLoader());
    }
}
