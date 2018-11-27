package GOF23;

import java.time.Duration;
import java.time.Instant;
import java.util.concurrent.CountDownLatch;

/**
 * 测试多线程环境下五种单例创建的效率
 */
public class P250_test {
    public static void main(String[] args) throws InterruptedException {

        Instant now = Instant.now();
        int threadNum = 10;
        CountDownLatch cdl = new CountDownLatch(threadNum);
        for(int i=0;i<threadNum;i++){
            new Thread(new Runnable() {
                @Override
                public void run() {
                    for(int i=0;i<100000;i++){
                        Object o = P248_懒汉.getInstance();
                    }
                    cdl.countDown();
                }
            }).start();
        }
        cdl.await();
        Instant end = Instant.now();
        System.out.println("花时: "+ Duration.between(now,end).toMillis());
    }
}
