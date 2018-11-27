package GOF23.P274_观察者模式;

public class client {
    public static void main(String[] args) {
        //创建对象
        Subject subject = new ConcreteSubject();

        //创建多个观察者
        Observer o1 = new ObserverA();
        Observer o2 = new ObserverA();
        Observer o3 = new ObserverA();

        //让这三个观察者添加到subject对象的观察者队列中
        subject.registerObserver(o1);
        subject.registerObserver(o2);
        subject.registerObserver(o3);

        //改变subject的状态
        ((ConcreteSubject) subject).setState(333);
        System.out.println(((ObserverA) o1).getMyState());
        System.out.println(((ObserverA) o2).getMyState());
        System.out.println(((ObserverA) o3).getMyState());

    }
}
