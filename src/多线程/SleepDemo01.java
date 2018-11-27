package 多线程;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 阻塞
 * 1)Join:合并线程
 * 2)yield:暂停自己的线程  static
 * 3)sleep:休眠，不释放锁
 *      1、与时间相关:倒计时
 *      2、模拟网络延迟
 *
 * 倒计时
 * 1、倒数10个数，一秒内打印一个
 *
 */
public class SleepDemo01 {
    public static void main(String[] args) throws InterruptedException {
        Date endTime = new Date(System.currentTimeMillis()+10*1000);
        long end = endTime.getTime();
        while(true){
            //输出
            System.out.println(new SimpleDateFormat("mm:ss").format(endTime));
            //构建下一秒时间
            endTime = new Date(endTime.getTime()-1000);
            //等待一秒
            Thread.sleep(1000);
            //判断十秒以内可以继续
            if(end-10000>endTime.getTime()){
                break;
            }
        }
    }
    public static void test1() throws InterruptedException {
        int num = 10;
        while(true){
            System.out.println(num--);
            Thread.sleep(1000);//暂停
            if(num<=0){
                break;
            }
        }
    }
}
