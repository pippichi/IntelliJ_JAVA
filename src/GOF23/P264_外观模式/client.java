package GOF23.P264_外观模式;

public class client {
    public static void main(String[] args) {
//        工商局 a = new 萧山区工商局();
//        a.checkName();
//        质检局 b = new 萧山质检局();
//        b.orgCodeCertificate();
//        税务局 c = new 萧山税务局();
//        c.taxCertificate();
//        银行 d = new 中国工商银行();
//        d.openAccount();
        new RegisterFacade().register();
    }
}
