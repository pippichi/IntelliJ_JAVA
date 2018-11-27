package java_util_concurrent的学习;

import java.util.concurrent.CountDownLatch;

/**
 * CountDownLatch: 闭锁，在完成某些运算时，只有其他所有线程的运算全部完成，当前运算才继续运行
 */
public class TestCountDownLatch {
    public static void main(String[] args) {
        final CountDownLatch latch = new CountDownLatch(5);  //这里的count  每次一个线程去操作它的时候就递减1 ， 当count变为0时，则表示可以继续执行了。
        LatchDemo id = new LatchDemo(latch);

        long start = System.currentTimeMillis();
        for(int i=0;i<5;i++){
            new Thread(id).start();
        }
        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        long end = System.currentTimeMillis();
        System.out.println("耗费时间："+(end-start));
    }
}
class LatchDemo implements Runnable{
    private CountDownLatch latch;

    public LatchDemo(CountDownLatch latch) {
        this.latch = latch;
    }

    @Override
    public void run() {
        synchronized(this) {
            try {
                for (int i = 0; i < 50000; i++) {
                    if (i % 2 == 0) {
                        System.out.println(i);
                    }
                }
            } finally {
                latch.countDown();  //count减一
            }
        }
    }
}
