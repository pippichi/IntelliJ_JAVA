package 多线程;

public class 生产者消费者模式_栈 {
    public static void main(String[] args) {
        SyncStack sStack = new SyncStack();
        Shengchan sc = new Shengchan(sStack);
        Xiaofei xf = new Xiaofei(sStack);

        sc.start();
        xf.start();
    }
}

class Mantou{
    int id;
    Mantou(int id){
        this.id = id;
    }
}

class SyncStack{
    int index = 0;
    Mantou[] ms = new Mantou[10];

    public synchronized void push(Mantou m) throws InterruptedException {
        while(index==ms.length){
            //wait后，线程会将持有的锁释放。sleep是即使睡着也持有互斥锁
            wait();
        }
        //唤醒在当前对象等待池中等待的第一个线程。
        //如果不唤醒的话，之后两个线程都会进入等待线程，没有人唤醒。
        Thread.sleep(200);
        notify();

        ms[index] = m;
        index++;
    }
    public synchronized Mantou pop() throws InterruptedException {
        while(index==0){
            wait();
        }
        Thread.sleep(500);
        notify();
        index--;
        return ms[index];
    }
}

class Xiaofei extends Thread{
    SyncStack ss = null;

    public Xiaofei(SyncStack ss){
        //TODO Auto-generated constructor stub
        this.ss = ss;
    }

    @Override
    public void run(){
        //TODO Auto-generated method stub
        for(int i=0;i<20;i++){
            try {
                Mantou m =ss.pop();
                System.out.println("吃馒头:"+m.id);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class Shengchan extends Thread{
    SyncStack ss = null;

    public Shengchan(SyncStack ss) {
        //TODO Auto-generated constructor stub
        this.ss = ss;
    }
    @Override
    public void run(){
        //TODO Auto-generated method stub
        for(int i=0;i<20;i++){
            System.out.println("造馒头:"+i);
            Mantou m = new Mantou(i);
            try {
                ss.push(m);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
