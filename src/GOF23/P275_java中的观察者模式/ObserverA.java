package GOF23.P275_java中的观察者模式;

import java.util.Observable;
import java.util.Observer;

public class ObserverA implements Observer {

    private int myState;

    @Override
    public void update(Observable o, Object arg) {
        myState = ((ConcreteSubject)o).getState();
    }

    public int getMyState() {
        return myState;
    }

    public void setMyState(int myState) {
        this.myState = myState;
    }
}
