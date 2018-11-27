package GOF23;

/**
 * 静态内部类实现方式(兼具了并发高效调用和延迟加载的优势)
 */
public class P249_静态内部类实现方式 {

    private static class SingletonClassInstance{
        private static final P249_静态内部类实现方式 instance = new P249_静态内部类实现方式();
    }
    public static P249_静态内部类实现方式 getInstance(){
        return SingletonClassInstance.instance;
    }
    private P249_静态内部类实现方式(){}
}
