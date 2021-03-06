package 重写泛型_泛型擦除;

/**
 * 父类为泛型类
 * 1、属性
 * 2、方法
 *
 * 要么同时擦除，要么子类大于等于父类的类型
 * 不能子类擦除，父类泛型
 * 1、属性类型
 *  父类中，随父类而定
 *  子类中，随子类而定
 *  2、方法重写：
 *   随父类而定
 * @param <T>
 */
public abstract class Father<T,T1> {
    T name;
    public abstract void test(T t);
}

/**
 * 子类声明时指定具体类型
 * 属性类型为具体类型
 * 方法同理
 */
class Child1 extends Father<String,Integer>{
    String t1;
    public void test(String t){

    }
}

/**
 * 子类为泛型类
 * @param <T1>
 * @param <T>
 */
class Child2<T1,T> extends Father<T,T1>{
    T1 t1;
    public void test(T t){

    }
}

/**
 * 子类为泛型类，父类不指定类型，泛型的擦除
 */
class Child3<T1,T2> extends Father{
    T1 name;
    public void test(Object t){

    }
}

/**
 *子类和父类同时擦除
 */
class Child4 extends Father{
    String t1;
    public void test(Object t){

    }
}