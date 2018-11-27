package 多线程;

/**
 * 优先级: 概率，不是绝对的先后顺序
 * MAX_PRIORITY     10
 * MIN_PRIORITY     1
 * NORM_PRIORITY    5(默认)
 *
 * 设置优先级:
 * setPriority()
 * getPriority()
 */
public class 多线程_优先级01 {
    public static void main(String[] args) {
        多线程_MyThread t1 = new 多线程_MyThread();
        Thread proxy = new Thread(t1,"qyf");
        多线程_MyThread t2 = new 多线程_MyThread();
        Thread proxy1 = new Thread(t2,"qyf1");

        proxy.setPriority(Thread.MIN_PRIORITY);
        proxy1.setPriority(Thread.MAX_PRIORITY);

        proxy.start();
        proxy1.start();
        try {
            Thread.sleep(100);
            t1.stop();
            t2.stop();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
