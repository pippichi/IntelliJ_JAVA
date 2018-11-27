package java_util_concurrent的学习;
/**
 * 一、用于解决多线程安全问题的方式：
 *
 * synchronized:隐式锁
 * 1. 同步代码块
 *
 * 2. 同步方法
 *
 * jdk 1.5 后：
 * 3. 同步锁 Lock
 * 注意：是一个显示锁，需要通过 lock() 方法上锁，必须通过 unlock() 方法进行释放锁
 */
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class 同步锁lock {
    public static void main(String[] args) {
        TestLock t1 = new TestLock();
        new Thread(t1,"1").start();
        new Thread(t1,"3").start();
        new Thread(t1,"2").start();
    }
}
class TestLock implements Runnable{
    private boolean flag = true;
    public int num = 10;
    private Lock lock = new ReentrantLock();
    @Override
    public void run() {
        while(flag){
            lock.lock();

            try{
                if(num>0){
                    try {
                        Thread.sleep(200);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("剩余：" + --num);
                }else{
                    stop();
                }
            }finally {
                lock.unlock();
            }
        }
    }
    public void stop(){
        flag = false;
    }
}
