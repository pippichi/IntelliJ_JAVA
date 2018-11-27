package 装饰设计模式_类似扩音器;

/**
 * 因此，Amplify类就是对Voice类的装饰
 *
 */
public class App {
    public static void main(String[] args) {
        Voice v = new Voice(100);
        v.say();
        Amplify a = new Amplify(v);
        a.say();
    }
}
