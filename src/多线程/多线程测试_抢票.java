package 多线程;

public class 多线程测试_抢票 implements Runnable{
    private int num = 10;
    @Override
    public void run() {
        while(true){
            if(num<=0){
                break;
            }
            System.out.println(Thread.currentThread().getName()+"抢到了"+num--);
        }
    }

    public static void main(String[] args) {
        //真实角色
        多线程测试_抢票 p1 = new 多线程测试_抢票();

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
