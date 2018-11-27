package 重写泛型_泛型擦除;

/**
 * 泛型的擦除
 * 1、继承|实现声明不指定类型
 * 2、使用时不指定类型
 * 统一Object对待
 * 1、消除编译器警告时使用Object
 * 2、不完全等同于Object，编译不会类型检查
 * @param <T>
 */
public class Generic<T> {
    private T javase;
    private T oracle;

    public T getJavase(){
        return javase;
    }
    public void setJavase(T javase){
        this.javase = javase;
    }
    public T getOracle() { return oracle; }
    public void setOracle(T oracle){
        this.oracle = oracle;
    }

    public static void main(String[] agrs){
        Generic generic = new Generic();
        Generic<Object> generic1 = new Generic<>();
        test(generic);//generic 相当于Object但是不完全等同于Object
        //擦除，不会类型检查
//        test(generic1);
        test1(generic);
        test1(generic1);
    }
    public static void test(Generic<Integer> g){

    }
    public static void test1(Generic<?> g){

    }
}
