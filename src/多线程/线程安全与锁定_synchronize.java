package 多线程;

/**
 * 同步:并发 多个线程访问同一份资源  确保资源安全  -->线程安全
 * synchronize -->同步
 *
 * 一、同步块
 * synchronize(引用类型|this|类.class){
 *
 * }
 *
 * 二、同步方法
 *
 */
public class 线程安全与锁定_synchronize implements Runnable {
    private int num = 10;
    private boolean flag = true;
    @Override
    public void run() {
        while(true){
            test03();
        }
    }

    //线程不安全
    public void test01(){
        if(num<=0){
            flag = false;
            return;
        }
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName()+"抢到了"+num--);
    }

    //线程安全
    public synchronized void test02(){
        if(num<=0){
            flag = false;
            return;
        }
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName()+"抢到了"+num--);
    }

    //线程不安全,锁定资源不正确
    public void test04(){
        //a b c 不会产生冲突
        synchronized((Integer)num){
            if(num<=0){
                flag = false;
                return;
            }
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+"抢到了-->"+num--);
        }
    }
    //线程安全,锁定正确
    public void test03(){
        //a b c 不会产生冲突
        synchronized(this){
            if(num<=0){
                flag = false;
                return;
            }
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+"抢到了-->"+num--);
        }
    }


    //锁定范围不正确
    public void test05(){
        //a b c 会产生冲突
        synchronized(this){
            if(num<=0){
                flag = false;
                return;
            }
        }
        try {
            Thread.sleep(50);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName()+"抢到了-->"+num--);

    }

    //锁定范围不正确
    public void test06(){

        if(num<=0){
            flag = false;
            return;
        }
        //a b c 会产生冲突
        synchronized(this) {
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "抢到了-->" + num--);
        }

    }

    public static void main(String[] args) {
        //真实角色
        线程安全与锁定_synchronize p1 = new 线程安全与锁定_synchronize();

        //代理
        Thread t1 = new Thread(p1,"小强");
        Thread t3 = new Thread(p1,"小明");
        Thread t2 = new Thread(p1,"小刘");

        //启动线程
        t1.start();
        t2.start();
        t3.start();
    }
}
