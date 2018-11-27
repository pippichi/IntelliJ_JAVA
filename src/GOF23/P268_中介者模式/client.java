package GOF23.P268_中介者模式;

public class client {
    public static void main(String[] args) {
        Mediator m = new President();
        Department d1 = new Market(m);
        Department d2 = new Development(m);
        Department d3 = new Finacial(m);

        d1.selfAction();
        d1.outAction();
    }
}
