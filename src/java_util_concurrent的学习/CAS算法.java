package java_util_concurrent的学习;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * CAS (Compare-And-Swap)是一种硬件对并发的支持，针对多处理器操作而设计的处理器中的一种特殊指令，用于管理对共享数据的并发访问。
 * CAS 是一种无锁的非阻塞算法的实现。
 * CAS 包含了3 个操作数： （1）需要读写的内存值V （2）进行比较的值A （3）拟写入的新值B
 * 当且仅当V 的值等于A 时，CAS 通过原子方式用新值B 来更新V 的值，否则不会执行任何操作。
 *
 * 原子变量：
 *      类的小工具包，支持在单个变量上解除锁的线程安全编程。事实上，此包中的类可将volatile值、字段和数组元素的概念扩展到那些也提供原子条件更新操作的类。
 *      类AtomicBoolean、AtomicInteger、AtomicLong 和AtomicReference 的实例各自提供对相应类型单个变量的访问和更新。每个类也为该类型提供适当的实用工具方法。
 *      AtomicIntegerArray、AtomicLongArray 和AtomicReferenceArray 类进一步扩展了原子操作，对这些类型的数组提供了支持。这些类在为其数组元素提供volatile 访问语义方面也引人注目，这对于普通数组来说是不受支持的。
 *      核心方法：boolean compareAndSet(expectedValue, updateValue)
 * java.util.concurrent.atomic 包下提供了一些原子操作的常用类
 *
 *
 * 一、i++ 的原子性问题：i++ 的操作实际上分为三个步骤“读-改-写”
 *  *        int i = 10;
 *  *        i = i++; //10
 *  *
 *  *        int temp = i;
 *  *        i = i + 1;
 *  *        i = temp;
 *  *
 *  * 二、原子变量：在 java.util.concurrent.atomic 包下提供了一些原子变量。
 *  *      1. 属性被volatile修饰 保证内存可见性
 *  *      2. CAS（Compare-And-Swap） 算法保证数据变量的原子性
 *  *          CAS 算法是硬件对于并发操作的支持
 *  *          CAS 包含了三个操作数：
 *  *          ①内存值  V
 *  *          ②预估值  A
 *  *          ③更新值  B
 *  *          当且仅当 V == A 时， V = B; 否则，不会执行任何操作。
 */
public class CAS算法 {
    public static void main(String[] args) {
        AtomicDemo ad = new AtomicDemo();
        for (int i = 0; i < 10; i++) {
            new Thread(ad).start();
        }
    }
}
class AtomicDemo implements Runnable{
    private AtomicInteger serialNum = new AtomicInteger(0);
    @Override
    public void run() {
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(getSerialNum());
    }
    public int getSerialNum(){
        return serialNum.getAndIncrement();
    }
}
//结果：
//      0
//      2
//      1
//      3
//      9
//      8
//      7
//      6
//      5
//      4


//class AtomicDemo implements Runnable{
//    //private volatile int serialNumber = 0;volatile不能保证原子性，问题依旧存在
//    private int serialNum = 0;
//
//    @Override
//    public void run() {
//        try {
//            Thread.sleep(200);
//        } catch (InterruptedException e) {
//        }
//
//        System.out.println(Thread.currentThread().getName()+":"+getSerialNumber());
//    }
//    public int getSerialNumber(){
//        return serialNum++;
//    }
//}
//结果：
//      Thread-2:7
//      Thread-7:1
//      Thread-6:5
//      Thread-3:6
//      Thread-1:4
//      Thread-4:3
//      Thread-8:0   重复
//      Thread-0:8
//      Thread-9:2
//      Thread-5:0   重复
