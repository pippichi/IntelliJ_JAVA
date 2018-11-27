package 自定义泛型_深入_无多态;

/**
 * ?的使用:声明在类型|声明在方法上，不能声明类或使用时
 * ?类型不定，使用时确定类型
 */
public class Student<T> {
    T score;

    public static void main(String[] args){
        Student<?> stu = new Student<String>();
        test(new Student<Integer>());
        test2(new Student<Apple>());
        test3(new Student<Fruit>());
        test3(new Student<Object>());
        //test3(stu);使用时确定类型
        //stu = new Student<Fruit>();
        //test3(stu);
    }
    public static void test(Student<?> stu){

    }
    public static void test2(Student<? extends Fruit> stu){

    }
    public static void test3(Student<? super Fruit> stu){

    }
}
