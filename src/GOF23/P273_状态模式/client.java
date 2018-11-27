package GOF23.P273_状态模式;

public class client {
    public static void main(String[] args) {
        Context ctx = new Context();

        ctx.setState(new FreeState());
        ctx.setState(new BookedState());
    }
}
