package GOF23.P271_策略模式;

public class client {
    public static void main(String[] args) {
        Strategy s1 = new OldCustomerFewStrategy();
        Context ctx = new Context(s1);

        ctx.pringPrice(998);
    }
}
