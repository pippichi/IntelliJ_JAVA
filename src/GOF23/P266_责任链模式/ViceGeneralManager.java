package GOF23.P266_责任链模式;

/**
 * 副经理
 */
public class ViceGeneralManager extends Leader{

    public ViceGeneralManager(String name) {
        super(name);
    }

    @Override
    public void handleRequest(LeaveRequest request) {
        if(request.getLeaveDays()<20){
            System.out.println("员工: "+request.getEmpName()+" 请假，天数: "+request.getLeaveDays()+" 理由: "+request.getReason());
            System.out.println("副经理: "+this.name+" 审批通过!");
        }else{
            if(this.nextLeader!=null){
            this.nextLeader.handleRequest(request);}
        }
    }
}