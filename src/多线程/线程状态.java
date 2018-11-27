package 多线程;

import 自定义泛型_深入_无多态.Student;

/**
 * 一、线程状态
 * 1、新生状态
 * 2、就绪状态
 * 3、运行状态
 * 4、就绪状态
 * 5、死亡状态
 *
 * 二、停止线程
 * 1、自然终止:线程体正常执行完毕
 * 2、外部干涉:
 *      1)、线程类中 定义 线程体使用的标识
 *      2)、线程体使用该标识
 *      3)、提供对外方法改变标识
 *      4)、外部根据条件调用该方法即可
 */
public class 线程状态 {
    public static void main(String[] args) {
        Study s1 = new Study();
        new Thread(s1).start();
        for(int i=0;i<100;i++){
            if(i==50){
                s1.stop();
            }
            System.out.println("main....."+i);
        }
    }
}

class Study implements Runnable{
    //线程中 定义 线程体使用的标识
    private boolean flag = true;
    @Override
    public void run() {
        //线程体使用该标识
        while(flag){
            System.out.println("running...");
        }

    }
    //对外提供方法改变标识
    public void stop(){
        flag = false;
    }
}
