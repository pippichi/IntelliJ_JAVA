package GOF23.P264_外观模式;

public interface 税务局 {
    void taxCertificate();  //办理税务登记证
}

class 萧山税务局 implements 税务局{

    @Override
    public void taxCertificate() {
        System.out.println("在萧山税务局办理税务登记证!");
    }
}
