package GOF23.P275_java中的观察者模式;

public class client {
    public static void main(String[] args) {
        //创建对象
        ConcreteSubject subject = new ConcreteSubject();

        //创建多个观察者
        ObserverA o1 = new ObserverA();
        ObserverA o2 = new ObserverA();
        ObserverA o3 = new ObserverA();

        //让这三个观察者添加到subject对象的观察者队列中
        subject.addObserver(o1);
        subject.addObserver(o2);
        subject.addObserver(o3);

        //改变subject的状态
        subject.set(333);
        System.out.println(o1.getMyState());
        System.out.println(o2.getMyState());
        System.out.println(o3.getMyState());

    }
}
