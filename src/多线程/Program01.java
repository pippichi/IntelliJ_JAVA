package 多线程;

public class Program01 implements Runnable{
    @Override
    public void run() {
        for(int i=0;i<1000;i++){
            System.out.println(i+"一边敲代码。。。");
        }
    }
}
