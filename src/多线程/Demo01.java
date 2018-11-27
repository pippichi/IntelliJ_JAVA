package 多线程;

public class Demo01 {
    public static void main(String[] args) {
        //创建子类对象
        Demo01_rabbit rabbit = new Demo01_rabbit();
        Demo01_cat cat = new Demo01_cat();

        //调用start()方法
        //注意 不要调用run()方法
        rabbit.start();
        cat.start();

        for(int i=0;i<100;i++){
            System.out.println("test"+i);
        }
    }
}
