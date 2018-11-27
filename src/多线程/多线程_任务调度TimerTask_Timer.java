package 多线程;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 * schedule(TimerTask task,Date time)
 * schedule(TimerTask task,Date firstTime,long period)
 *
 * 自学QUARTZ
 */
public class 多线程_任务调度TimerTask_Timer {
    public static void main(String[] args) throws InterruptedException {
        Timer t1 = new Timer("q");
        t1.schedule(new TimerTask(){
            @Override
            public void run(){
                System.out.println("it is q");
            }
        },new Date(System.currentTimeMillis()+3000),200);

        Thread.sleep(5000);
    }
}
