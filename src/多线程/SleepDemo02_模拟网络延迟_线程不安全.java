package 多线程;

/**
 * Sleep 模拟网络延迟  线程不安全
 *
 * 模拟并发问题
 */
public class SleepDemo02_模拟网络延迟_线程不安全 implements Runnable{
    private int num = 100;
    @Override
    public void run() {
        while(true){
            if(num<=0){
                break;
            }
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+"抢到了"+num--);
        }
    }

    public static void main(String[] args) {
        //真实角色
        SleepDemo02_模拟网络延迟_线程不安全 p1 = new SleepDemo02_模拟网络延迟_线程不安全();

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
