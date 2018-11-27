package JVM_测试类加载全过程;

/**
 * 字节码编译好之后，每个类都会将常量符号放入常量池，但是还不能用
 * 需要通过解析才能将虚拟机常量池内的符号变成直接引用
 */
public class P242 {

    static {
        System.out.println("静态初始化P242");
    }

    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException {
        System.out.println("main");

        //主动引用
//        A a = new A();
//        System.out.println(a.width);
////        类加载初始化就只有这么一次，加载一次之后就不必再次加载了
//        A a2 = new A();

//        //被动引用
////        A没有被初始化
//        System.out.println(A.MAX);
////        A被初始化
//        System.out.println(A.width);

//        //反射引用
//        Class.forName("JVM_测试类加载全过程.A");

////        没有初始化
//        A[] as = new A[10];

////        A被初始化，B没有初始化,只有真正定义所用到的静态域的那个类才被初始化
//        System.out.println(B.width);
    }
}

class B extends A{
    static {
        System.out.println("静态初始化B");
    }
}

class A extends A_Fa{
    public static int width = 100;
    public static final int MAX = 50;

    static {
        System.out.println("静态初始化类A");
        width = 300;
    }
    public A(){
        System.out.println("创建A类的对象");
    }
}

class A_Fa{
    static {
        System.out.println("加载父类");
    }
}