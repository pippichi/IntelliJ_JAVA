package 多线程;

/**
 * Thread.currentThread(),由于是static方法，因此写在哪个线程里就返回哪个线程
 *      setName()
 *      getName()
 *      isAlive()
 */
public class 多线程_优先级 {
    public static void main(String[] args) throws InterruptedException {
        多线程_MyThread t1 = new 多线程_MyThread();
        Thread proxy = new Thread(t1,"qyf");
        proxy.setName("test");
        System.out.println(Thread.currentThread().getName());//main 的Name
        System.out.println(proxy.getName());
        proxy.start();

        System.out.println(proxy.isAlive());
        Thread.sleep(200);
        t1.stop();
        Thread.sleep(200);
        System.out.println(proxy.isAlive());
    }
}
