package GOF23;

/**
 * 测试饿汉式单例模式
 */
public class P248_饿汉 {

    //类初始化时立即加载(没有延时加载的优势)，天然的是线程安全的!
    private static P248_饿汉 instance = new P248_饿汉();

    private P248_饿汉(){}

    //方法没有同步，调用效率高!
    public static P248_饿汉 getInstance(){
        return instance;
    }
}
