package GOF23.P259_动态代理;

import java.lang.reflect.Proxy;

public class client {
    public static void main(String[] args) {
        Star realStar = new RealStar();
        StarHandler handler = new StarHandler(realStar);

        Star proxy = (Star) Proxy.newProxyInstance(ClassLoader.getSystemClassLoader(),new Class[]{Star.class},handler);
        proxy.bookTicket();
        proxy.sing();
    }
}
