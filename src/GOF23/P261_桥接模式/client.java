package GOF23.P261_桥接模式;

public class client {
    public static void main(String[] args) {
        //销售联想的笔记本
        Computer2 c = new Laptop2(new Lenovo());
        c.sale();

        //销售神舟电脑
        Computer2 c2 = new Desktop2(new Shenzhou());
        c2.sale();
    }
}
