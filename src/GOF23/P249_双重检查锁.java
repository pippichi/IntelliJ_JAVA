package GOF23;

/**
 * 双重检查锁实现单例模式
 * 由于JVM底层原因最好不要用，会出错.
 */
public class P249_双重检查锁 {
    private P249_双重检查锁(){}
    private static P249_双重检查锁 instance;
    public static P249_双重检查锁 getInstance(){
        if(instance==null){
            P249_双重检查锁 sc;
            synchronized(P249_双重检查锁.class){
                sc = instance;
                if(sc==null){
                    synchronized (P249_双重检查锁.class){
                        if(sc==null){
                            sc = new P249_双重检查锁();
                        }
                    }
                    instance = sc;
                }
            }
        }
        return instance;
    }
}
