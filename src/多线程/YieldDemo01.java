package 多线程;
/**
 * 阻塞
 * 1)Join:合并线程
 * 2)yield:暂停自己的线程  static
 * 3)sleep:休眠，不释放锁
 *      1、与时间相关:倒计时
 *      2、模拟网络延迟
 */
public class YieldDemo01 extends Thread{
    @Override
    public void run(){
        for(int i=0;i<1000;i++){
            System.out.println("running..."+i);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        YieldDemo01 d1 = new YieldDemo01();//新生
        d1.start();//就绪
        //cpu调度运行
        for(int i=0;i<100;i++){
            if(i%20==0){
                //暂停本线程main，由于是静态方法，因此写在哪个线程里就暂停哪个线程（此方法不太准，看CPU）
                Thread.yield();
            }
            System.out.println("main..."+i);
        }
    }
}

