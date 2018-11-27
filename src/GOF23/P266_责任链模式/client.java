package GOF23.P266_责任链模式;

public class client {
    public static void main(String[] args) {
        Leader a = new Director("张三");
        Leader b = new Manager("李四");
        Leader c =  new GeneralManager("王五");
        Leader b2 = new ViceGeneralManager("赵六");

        //设置责任对象
        a.setNextLeader(b);
        b.setNextLeader(b2);
        b2.setNextLeader(c);

        //开始请假操作
        LeaveRequest req1 = new LeaveRequest("TOM",19,"回老家!");
        a.handleRequest(req1);
    }
}
