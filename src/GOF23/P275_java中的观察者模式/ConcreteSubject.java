package GOF23.P275_java中的观察者模式;


import java.util.Observable;

/**
 * 目标对象
 */
public class ConcreteSubject extends Observable {

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    private int state;

    public void set(int s){
        state = s;  //目标对象的状态发生了改变

        setChanged();   //表示目标对象已经做了更改

        notifyObservers(state);  //通知所有的观察者

    }
}