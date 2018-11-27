package GOF23.P266_责任链模式;

/**
 * 抽象类
 */
public abstract class Leader {

    protected String name;
    protected Leader nextLeader;

    public Leader(String name) {
        this.name = name;
    }

    //设置责任链上的后链对象
    public void setNextLeader(Leader nextLeader) {
        this.nextLeader = nextLeader;
    }

    //处理请求的核心的业务方法
    public abstract void handleRequest(LeaveRequest request);
}
