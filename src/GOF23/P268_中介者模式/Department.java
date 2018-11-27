package GOF23.P268_中介者模式;

//同时类接口
public interface Department {
    void selfAction();  //做本部门的事情
    void outAction();   //向总经理发出申请
}
