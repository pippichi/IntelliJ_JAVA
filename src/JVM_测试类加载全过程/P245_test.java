package JVM_测试类加载全过程;

/**
 * 测试自定义的FileSystemClassLoader
 */
public class P245_test {
    public static void main(String[] args) throws ClassNotFoundException {
//        不同加载器加载的类被JVM认为是不同的类
        P245 loader = new P245("D:/IntelliJ_JAVA/src");
        P245 loader2 = new P245("D:/IntelliJ_JAVA/src");

        Class<?> c = loader.loadClass("Ploygon_Polyline.Display");
        Class<?> c2 = loader.loadClass("Ploygon_Polyline.Display");
        Class<?> c3 = loader2.loadClass("Ploygon_Polyline.Display");
        Class<?> c4 = loader2.loadClass("java.lang.String");

        System.out.println(c.hashCode());
        System.out.println(c2.hashCode());
        System.out.println(c3.hashCode());
        System.out.println(c3.getClassLoader());//系统默认的类加载器
        System.out.println(c4.hashCode());
        System.out.println(c4.getClassLoader());//引导类加载器

    }
}
