package 多态;

public class duotai4 {
    public static void main(String[] args){
        zilei2 a = new zilei2();
        zilei1 b = new zilei2();
        zilei1 c = new zilei3();

        a.hello();
        b.hello();
        c.hello();

    }
}
abstract class zilei1{
    public zilei1(){
        System.out.println("it is zilei1");
    }
    public abstract void hello();
}
class zilei2 extends zilei1{
    public zilei2(){
        System.out.println("it is zilei2");
    }
    public void hello(){
        System.out.println("zilei2hello");
    }
}
class zilei3 extends zilei2{
    public zilei3(){
        System.out.println("it is zilei3");
    }
    public void hello(){
        super.hello();
        System.out.println("zilei3hello");
    }
}
