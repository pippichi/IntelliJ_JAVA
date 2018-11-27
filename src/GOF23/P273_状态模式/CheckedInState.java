package GOF23.P273_状态模式;

/**
 * 已入住状态
 */
public class CheckedInState implements State
{
    @Override
    public void handle() {
        System.out.println("已入住！");
    }
}
