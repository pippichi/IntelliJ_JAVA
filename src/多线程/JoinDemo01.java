package 多线程;

/**
 * 阻塞
 * 1)Join:合并线程
 * 2)yield:暂停自己的线程  static
 * 3)sleep:休眠，不释放锁
 *      1、与时间相关:倒计时
 *      2、模拟网络延迟
 */
public class JoinDemo01 extends Thread{
    @Override
    public void run(){
        for(int i=0;i<100;i++){
            System.out.println("running..."+i);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        JoinDemo01 d1 = new JoinDemo01();//新生
        d1.start();//就绪

        //cpu调度运行
        for(int i=0;i<100;i++){
            if(i==50){
                d1.join();//main阻塞。。。
            }
            System.out.println("main..."+i);
        }
    }
}
