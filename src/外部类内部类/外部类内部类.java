package 外部类内部类;

public class 外部类内部类 {
    public static void main(String[] args){
        Face f = new Face();
        Face.Nose nose = f.new Nose();
        f.printFace();
        nose.printNose();
        Face.Ear ear = new Face.Ear();
        ear.printEar();
    }
}
class Face{
    String type = "Face";
    void printFace(){
        System.out.println(nose.type);
    }
    Nose nose = new Nose();
    //非静态内部类
    class Nose{
        String type = "Nose";
        void printNose(){
            System.out.println(Face.this.type);
            System.out.println(this.type);
        }
    }
    //静态内部类
    static class Ear{
        void printEar(){
            System.out.println("我在听");
        }
    }

}
