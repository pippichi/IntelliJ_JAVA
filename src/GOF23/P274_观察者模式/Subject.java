package GOF23.P274_观察者模式;

import java.util.ArrayList;
import java.util.List;

public class Subject {

    protected List<Observer> list = new ArrayList<>();

    public void registerObserver(Observer obs){
        list.add(obs);
    }
    public void removeObserver(Observer obs){
        list.remove(obs);
    }

    //通知所有观察者更新状态
    public void notifyAllObservers(){
        list.forEach(x->x.update(this));
    }
}
