package GOF23.P257_适配器;

/**
 * 客户端(相当于例子中的笔记本,只有usb接口)
 */
public class client {

    public void test1(Target t){
        t.handleReq();
    }

    public static void main(String[] args) {
        client c = new client();

        Adaptee a = new Adaptee();

//        Target t = new Adapter();

        Target t = new Adapter2(a);

        c.test1(t);
    }
}
