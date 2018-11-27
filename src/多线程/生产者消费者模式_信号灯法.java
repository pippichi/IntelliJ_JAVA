package 多线程;

public class 生产者消费者模式_信号灯法 {
    public static void main(String[] args) {
        Movie m = new Movie();
        Player p = new Player(m);
        Watcher w = new Watcher(m);
        Thread t1 = new Thread(p);
        Thread t2 = new Thread(w);

        t1.start();
        t2.start();
    }
}

/**
 * 一个场景，共同的资源
 * 生产者消费者模式
 * wait():等待，释放锁 sleep(): 不释放锁  与synchronized一起使用
 * notify()/notifyAll():唤醒  与synchronized一起使用
 */
class Movie{
    private String s;
    //flag->true  生产者生产，消费者等待，生产完后通知消费
    //flag->false  消费者消费，生产者等待，消费完后通知生产
    public boolean flag = true;
    /**
     * 播放
     * @param s
     */
    public synchronized void play(String s){
        if(!flag){//生产者等待
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        //开始生产
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //生产完毕
        this.s = s;
        //生产物品
        System.out.println("生产了"+s);
        //通知消费
        this.notify();
        //生产者停下
        flag = false;
    }

    public synchronized void watch() {
        if(flag){//消费者等待
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        //开始消费
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //消费完毕
        System.out.println("消费了"+s);
        //通知生产
        this.notifyAll();
        //消费停止
        flag = true;
    }
}

/**
 * 生产者
 */
class Player implements Runnable{
    private Movie m;

    public Player(Movie m) {
        this.m = m;
    }

    @Override
    public void run() {
        for(int i=0;i<20;i++){
            if(i%2==0){
                m.play("左青龙");
            }else{
                m.play("右白虎");
            }
        }
    }
}

/**
 * 消费者
 */
class Watcher implements Runnable{
    private Movie m;

    public Watcher(Movie m) {
        this.m = m;
    }

    @Override
    public void run() {
        for(int i=0;i<20;i++){
            m.watch();
        }
    }
}