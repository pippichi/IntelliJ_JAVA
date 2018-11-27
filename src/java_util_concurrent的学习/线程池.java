package java_util_concurrent的学习;
/**
 * 一、线程池：提供了一个线程队列，队列中保存着所有等待状态的线程。避免了创建与销毁额外开销，提高了响应的速度。
 *
 * 二、线程池的体系结构：
 *  java.util.concurrent.Executor : 负责线程的使用与调度的根接口
 *      |--**ExecutorService 子接口: 线程池的主要接口
 *          |--ThreadPoolExecutor 线程池的实现类
 *          |--ScheduledExecutorService 子接口：负责线程的调度
 *              |--ScheduledThreadPoolExecutor ：继承 ThreadPoolExecutor， 实现 ScheduledExecutorService
 *
 * 三、工具类 : Executors
 * ExecutorService newFixedThreadPool() : 创建固定大小的线程池
 * ExecutorService newCachedThreadPool() : 缓存线程池，线程池的数量不固定，可以根据需求自动的更改数量。
 * ExecutorService newSingleThreadExecutor() : 创建单个线程池。线程池中只有一个线程
 *
 * ScheduledExecutorService newScheduledThreadPool() : 创建固定大小的线程，可以延迟或定时的执行任务。
 */

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class 线程池 {
    public static void main(String[] args) {

        //1. 创建线程池
        ExecutorService e = Executors.newCachedThreadPool();

        //2. 为线程池中的线程分配任务
        Add a = new Add();
        for(int i=0;i<5;i++) {
            e.submit(a);
        }

        List<Future<Integer>> list = new ArrayList<>();
        for(int i=0;i<10;i++) {
            Future<Integer> f = e.submit(new Callable<Integer>() {
                @Override
                public Integer call() throws Exception {
                    int sum = 0;
                    for (int i = 0; i < 10; i++) {
                        sum += i;
                    }

                    return sum;
                }
            });
            list.add(f);
        }
        //3、关闭线程池
        e.shutdown();
        for(Future<Integer> f:list) {
            try {
                System.out.println(f.get());
            } catch (InterruptedException e1) {
                e1.printStackTrace();
            } catch (ExecutionException e1) {
                e1.printStackTrace();
            }
        }

    }
}

class Add implements Runnable{
    @Override
    public void run() {
        for(int i=0;i<2;i++){
            System.out.println(Thread.currentThread().getName()+"--->"+i);
        }

    }
}
