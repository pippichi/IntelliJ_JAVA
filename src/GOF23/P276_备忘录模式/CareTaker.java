package GOF23.P276_备忘录模式;

import java.util.ArrayList;
import java.util.List;

/**
 * 负责人类
 * 负责管理备忘录对象
 */
public class CareTaker {
    private EmpMemento mmt;

//    private List<EmpMemento> list = new ArrayList<>();

    public EmpMemento getMmt() {
        return mmt;
    }

    public void setMmt(EmpMemento mmt) {
        this.mmt = mmt;
    }
}
