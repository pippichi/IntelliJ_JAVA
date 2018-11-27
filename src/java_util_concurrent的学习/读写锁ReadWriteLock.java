package java_util_concurrent的学习;
/**
 * 1. ReadWriteLock : 读写锁
 *
 * 写写/读写 需要“互斥”
 * 读读 不需要互斥
 *
 */
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class 读写锁ReadWriteLock {
    public static void main(String[] args) {
        Manager m = new Manager();
        new Thread(new Runnable() {
            @Override
            public void run() {
                m.setNum((int)(Math.random()*101));
            }
        },"Writer").start();

        for(int i=0;i<100;i++){
            new Thread(new Runnable() {
                @Override
                public void run() {
                    m.getNum();
                }
            },"Reader"+(i+1)).start();
        }
    }
}
class Manager{
    private int num = 10;
    private ReadWriteLock lock = new ReentrantReadWriteLock();

//写
    public void setNum(int num){
        lock.writeLock().lock();
        try {
            System.out.println(Thread.currentThread().getName());
            this.num = num;
        }finally{
            lock.writeLock().unlock();
        }
    }
//读
    public void getNum(){
        //上锁
        lock.readLock().lock();
        try {
            System.out.println(Thread.currentThread().getName() + "--->" + num);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }finally {
            //解锁
            lock.readLock().unlock();
        }
    }
}