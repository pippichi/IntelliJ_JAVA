package GOF23;

/**
 * 测试懒汉式单例模式
 */
public class P248_懒汉 {

    //类初始化时，不初始化这个对象（延时加载，真正用的时候再创建）
    private static P248_懒汉 instance;

    private P248_懒汉(){}

    //方法同步，调用效率低!
    public static synchronized P248_懒汉 getInstance() {
        if(instance==null){
            instance = new P248_懒汉();
        }
        return instance;
    }
}
