package 多线程;

/**
 * 模拟龟兔赛跑
 * 1、创建多线程 继承Thread  +重写run(线程体)
 * 2、使用线程:创建子类对象+对象.start() 线程启动
 */
public class Demo01_rabbit extends Thread {
    @Override
    public void run(){
        for(int i=0;i<100;i++){
            System.out.println("兔子跑了"+i+"步");
        }
    }
}

class Demo01_cat extends Thread {
    @Override
    public void run(){
        for(int i=0;i<100;i++){
            System.out.println("猫跑了"+i+"步");
        }
    }
}
