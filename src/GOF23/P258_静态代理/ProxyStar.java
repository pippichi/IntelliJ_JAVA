package GOF23.P258_静态代理;

public class ProxyStar implements Star{

    private Star star;

    public ProxyStar(Star star) {
        this.star = star;
    }

    @Override
    public void confer() {
        System.out.println("RealStar.confer()");
    }

    @Override
    public void signContract() {
        System.out.println("RealStar.signContarct()");
    }

    @Override
    public void bookTicket() {
        System.out.println("RealStar.bookTicket()");

    }

    @Override
    public void sing() {
        star.sing();
    }

    @Override
    public void collectMoney() {
        System.out.println("RealStar.collectMoney()");
    }
}