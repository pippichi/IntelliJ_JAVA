package GOF23.P264_外观模式;

public interface 银行 {
    void openAccount();  //办理税务登记证
}

class 中国工商银行 implements 银行{

    @Override
    public void openAccount() {

        System.out.println("在中国工商银行开户！");
    }
}
