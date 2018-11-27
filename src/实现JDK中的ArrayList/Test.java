package 实现JDK中的ArrayList;

public class Test {
    private String name;
    private int age;

    public Test(){
        name = "qyf";
    }
    public Test(String name,int age){
        this();
        this.name = name;
        this.age = age;
    }
    public String getName(){
        return name;
    }
}
