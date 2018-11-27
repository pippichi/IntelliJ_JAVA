package GOF23.P257_适配器;

/**
 * 适配器(对象配器方式,使用了组合的方式跟被适配对象整合)
 */
public class Adapter2 implements Target {

    private Adaptee adaptee;

    public Adapter2(Adaptee adaptee) {
        this.adaptee = adaptee;
    }

    @Override
    public void handleReq() {
        adaptee.request();
    }
}
