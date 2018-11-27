package GOF23.P273_状态模式;

/**
 * 已预定状态
 */
public class BookedState implements State
{
    @Override
    public void handle() {
        System.out.println("已被预定！");
    }
}
