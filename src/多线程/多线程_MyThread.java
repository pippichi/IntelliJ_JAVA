package 多线程;

public class 多线程_MyThread implements Runnable {
    private boolean flag = true;

    public int num = 0;
    @Override
    public void run() {
        while(flag){
            System.out.println(Thread.currentThread().getName()+"--->"+num++);
        }
    }
    public void stop(){
        flag = !flag;
    }
}
