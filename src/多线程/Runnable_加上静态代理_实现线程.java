package 多线程;

/**
 * 使用Runnable创建线程
 * 1、类 实现Runnable接口+重写run()  -->真实角色类
 * 2、启动多线程 使用静态代理
 *      1)、创建真实角色
 *      2)、创建代理角色+真实角色引用
 *      3)、调用.start()启动线程
 *
 *
 * 优点:
 * 1)避免单继承的局限性
 * 2)便于共享资源
 */
public class Runnable_加上静态代理_实现线程  {
    public static void main(String[] args) {
        //  1)、创建真实角色
        Program01 p1 = new Program01();
        //  2)、创建代理角色+真实角色引用
        Thread t1 = new Thread(p1,"t1");
        //  3)、调用.start()启动线程
        t1.start();

        for(int i=0;i<1000;i++){
            System.out.println(i+"多线程");
        }
    }
}
