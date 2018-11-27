package GOF23.P273_状态模式;

/**
 * 房间对象
 */
public class Context {
    //如果是银行系统，这个Context类就是账号，根据金额不同，切换不同账号!

    private State state;

    public void setState(State state) {
        System.out.println("修改状态!");
        this.state = state;
        state.handle();
    }
}
