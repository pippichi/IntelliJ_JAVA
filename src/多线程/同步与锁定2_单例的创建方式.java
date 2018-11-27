package 多线程;

/**
 * 单例的创建方式
 * 1、懒汉式
 * 1)构造器私有化
 * 2)声明私有的静态属性
 * 3)对外提供访问属性的静态方法，确保该对象存在
 */

//懒汉式
public class 同步与锁定2_单例的创建方式 {
    private static 同步与锁定2_单例的创建方式 instance;
    private 同步与锁定2_单例的创建方式(){}
    public static 同步与锁定2_单例的创建方式 getInstance(){
        if(null==instance){//提供效率
            synchronized(同步与锁定2_单例的创建方式.class){
                if(null==instance){//安全
                    instance = new 同步与锁定2_单例的创建方式();
                }
            }
        }
        return instance;
    }
}

/**
 * 单例的创建方式
 * 2、饿汉式
 * 1)构造器私有化
 * 2)声明私有的静态属性，同时创建该对象
 * 3)对外提供访问属性的静态方法，确保该对象存在
 */
//饿汉式
class 同步与锁定2_单例的创建方式1 {
    private static 同步与锁定2_单例的创建方式1 instance = new 同步与锁定2_单例的创建方式1();
    private 同步与锁定2_单例的创建方式1(){}
    public static 同步与锁定2_单例的创建方式1 getInstance(){
        return instance;
    }
}

//高效率的写法:原理---类在使用的时候才会被加载，因此将对象初始化封装在一个私有内部类里面，延缓加载时间，提高效率
class 同步与锁定2_单例的创建方式2 {
    private static class Jvmholder {
        private static 同步与锁定2_单例的创建方式2 instance = new 同步与锁定2_单例的创建方式2();
    }
    private 同步与锁定2_单例的创建方式2(){}
    public static 同步与锁定2_单例的创建方式2 getInstance(){
        return Jvmholder.instance;
    }
}
