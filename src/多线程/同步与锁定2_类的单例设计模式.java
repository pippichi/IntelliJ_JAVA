package 多线程;

/**
 * 单例设计模式:确保一个类只有一个对象
 */
public class 同步与锁定2_类的单例设计模式 {
    public static void main(String[] args) throws InterruptedException {
        JvmThread j1 = new JvmThread(100);
        JvmThread j2 = new JvmThread(500);
        j1.start();
        j2.start();
    }
}
/**
 * 单例设计模式:确保一个类只有一个对象
 * 懒汉式      double checking双重检查
 * 1、构造器私有化，避免外部直接创建对象
 * 2、声明一个私有的静态变量
 * 3、创建一个对外的公共的静态方法 访问该变量，如果变量没有对象，创建该对象
 */
class Jvm{
    //声明一个私有的静态变量
    private static Jvm instance = null;

    //构造器私有化，避免外部直接创建对象
    private Jvm(){

    }

    //方法一:    创建一个对外的公共的静态方法 访问该变量，如果变量没有对象，创建该对象
    /*public static Jvm getInstance(long time) throws InterruptedException {
        //a b  --->效率不高
        synchronized(Jvm.class){
            if (instance == null) {
                Thread.sleep(time);
                instance = new Jvm();
            }
        }
        return instance;
    }*/

    //方法二:    创建一个对外的公共的静态方法 访问该变量，如果变量没有对象，创建该对象
    /*public static synchronized Jvm getInstance(long time) throws InterruptedException {
        if (instance == null) {
            Thread.sleep(time);
            instance = new Jvm();
        }
        return instance;
    }*/

    //方法三(效率最高):    创建一个对外的公共的静态方法 访问该变量，如果变量没有对象，创建该对象
    public static Jvm getInstance(long time) throws InterruptedException {
        //c d-->发现已经有对象，直接return    提高已经存在对象的效率
        if(instance==null){
            //b -->a已经进去，已有了对象，直接return
            synchronized(Jvm.class){
                if(instance==null){
                    Thread.sleep(time);
                    instance = new Jvm();
                }
            }
        }
        return instance;
    }
}
class JvmThread extends Thread{
    private long time;
    public JvmThread(long time){
        this.time = time;
    }
    @Override
    public void run(){
        try {
            System.out.println(Thread.currentThread().getName()+"创建了--->"+Jvm.getInstance(time));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}