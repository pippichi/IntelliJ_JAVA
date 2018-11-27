package JVM_测试类加载全过程;

public class P244 {
    public static void main(String[] args) {
        System.out.println(ClassLoader.getSystemClassLoader());
        System.out.println(ClassLoader.getSystemClassLoader().getParent());
        System.out.println(ClassLoader.getSystemClassLoader().getParent().getParent());

        System.out.println(System.getProperty("java.class.path"));
        System.out.println("#################");

        String a = "q";
        System.out.println(a.getClass().getClassLoader());

    }
}
