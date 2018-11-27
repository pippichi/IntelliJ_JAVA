package GOF23.P274_观察者模式;

public class ConcreteSubject extends Subject {
    private int state;

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;

        this.notifyAllObservers();
    }
}
