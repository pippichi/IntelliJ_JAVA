package 多线程;

import java.io.ObjectInputStream;

/**
 * 过多的同步造成死锁
 */
public class 死锁 {
    public static void main(String[] args) {
        Object g = new Object();
        Object m = new Object();
        Test t1 = new Test(g,m);
        Test01 t2 = new Test01(g,m);
        Thread thread1 = new Thread(t1);
        Thread thread2 = new Thread(t2);
        thread1.start();
        thread2.start();
    }
}
class Test implements Runnable{
    Object goods;
    Object money;

    public Test(Object goods, Object money) {
        this.goods = goods;
        this.money = money;
    }

    @Override
    public void run() {
        while(true){
            test();
        }
    }
    public void test(){
        synchronized(goods){
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized(money){

            }
        }
        System.out.println("一手给钱一手给货");
    }
}

class Test01 implements Runnable{
    Object goods;
    Object money;

    public Test01(Object goods, Object money) {
        this.goods = goods;
        this.money = money;
    }

    @Override
    public void run() {
        while(true){
            test();
        }
    }
    public void test(){
        synchronized(money){
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized(goods){

            }
        }
        System.out.println("一手给货，一手给钱");
    }
}
