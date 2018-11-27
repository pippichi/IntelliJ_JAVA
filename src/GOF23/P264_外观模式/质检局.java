package GOF23.P264_外观模式;

public interface 质检局 {
    void orgCodeCertificate();  //办理税务登记证
}

class 萧山质检局 implements 质检局{

    @Override
    public void orgCodeCertificate() {
        System.out.println("在萧山区质检局办理培训机构代码证!");
    }
}
