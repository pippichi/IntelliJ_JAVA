package 多态;

public class duotai2 {
    public static void main(String[] args){
        new Z();
        new X();
    }
}
class Z{
    int i = 7;
    public Z(){
        setI(20);
        System.out.println("i from A is "+ i);
    }
    public void setI(int i){
        this.i = 2 * i;
    }
}
class X extends Z{
    public X(){
        super.setI(100);
        System.out.println("i from B is "+ i);
    }
    @Override
    public void setI(int i){
        this.i = 4 * i;
    }
}
