package GOF23.P269_命令模式;

/**
 * 避免客户直接和执行者打交道
 */
public class client {
    public static void main(String[] args) {
        Command c = new ConcreteCommand(new Receiver());

        Invoke i = new Invoke(c);

        i.call();
    }
}
