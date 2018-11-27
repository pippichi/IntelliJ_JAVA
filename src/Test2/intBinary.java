package Test2;

/**
 * 测试
 */
public class intBinary {
    private String name;
    private int age;

    public intBinary(String name,int age){
        this(name);//调用另一个构造器
        this.name = name;
        this.age = age;
        System.out.println("调用了构造器1");
    }
    public intBinary(String name){
        this.name = name;
        System.out.println("调用了构造器2");
    }
}
