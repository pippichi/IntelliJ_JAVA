package 重写泛型_泛型擦除;

/**
 * 泛型接口：与继承同理
 * 重写方法随父类而定
 * @param <T>
 */
public interface 接口<T> {
    void temp(T t);
}

/**
 * 声明子类是具体类型
 */
class Temp1 implements 接口<Integer>{
    public void temp(Integer t){

    }
}

/**
 * 擦除
 */
class Temp2 implements 接口{
    public void temp(Object t){

    }
}

/**
 * 父类擦除，子类泛型
 * @param <T>
 */
class Temp3<T> implements 接口{
    public void temp(Object t){

    }
}

/**
 * 子类泛型，父类泛型
 * @param <T>
 */
class Temp4<T> implements 接口<T>{
    public void temp(T t){

    }
}