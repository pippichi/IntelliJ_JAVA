package 外部类内部类.CallBack;

public class TestMyFrame {
    public static void drawFrame(MyFrame f){
        System.out.println("启动线程");
        System.out.println("增加循环");
        System.out.println("查看消息栈");

        //画窗口
        f.paint();

        System.out.println("启动缓存，增加效率");
    }
    public static void main(String[] args){
        drawFrame(new MyFrame01());
    }
}
class MyFrame01 extends MyFrame{
    @Override
    public void paint() {
        System.out.println("画出01的窗口");
    }
}
class MyFrame02 extends MyFrame{
    @Override
    public void paint() {
        System.out.println("画出02的窗口");
    }
}