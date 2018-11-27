package 多线程;

import java.util.concurrent.*;

/**
 * 使用Callable创建线程
 * 优点:
 *      可以返回异常同时可以返回值
 * 缺点:
 *      繁琐
 */
public class concurrent_Callable {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        //创建线程
        Project p = new Project("qyf",10L);
        Project p1 = new Project("qyf1",20L);
        ExecutorService ser = Executors.newFixedThreadPool(2);
        //获取值
        Future<Integer> result1 = ser.submit(p1);
        Future<Integer> result = ser.submit(p);

        Thread.sleep(2000); //2秒
        p.setFlag(false);  //停止线程体循环
        p1.setFlag(false);


        int num = result.get();
        int num1 = result1.get();
        System.out.println("qyf-->"+num+"\n qyf1-->"+num1);
        //停止服务
        ser.shutdownNow();
    }
}

class Project implements Callable<Integer>{
    private String name;//名称
    private long time;//延时时间
    private boolean flag = true;
    private int step = 0;//步

    public Project(String name) {
        this.name = name;
    }

    public Project() {
    }

    public Project(String name, long time) {
        this.name = name;
        this.time = time;
    }

    @Override
    public Integer call() throws Exception {
        while(flag){
            Thread.sleep(time);
            step++;
        }
        return step;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public int getStep() {
        return step;
    }

    public void setStep(int step) {
        this.step = step;
    }
}
