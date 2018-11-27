package 多态;

public class zuhe1 {
    public static void main(String[] args){
        A2 a2 = new A2();
        a2.run();
    }
}
class A1{
    public A1(){}
    public void run(){
        System.out.println("A1 run");
    }
}
class A2{
    A1 a1 = new A1();
    public A2(){}
    public void run(){
        a1.run();
        System.out.println("A2 run");
    }
}
