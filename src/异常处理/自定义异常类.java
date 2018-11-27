package 异常处理;

public class 自定义异常类 extends Exception{
    public 自定义异常类(){

    }
    public 自定义异常类(String message){
        super(message);
    }
}

class TestMyException{
    void test()throws 自定义异常类{

    }
    public static void main(String[] args){
        try{
            new TestMyException().test();
        }catch(自定义异常类 e){
            e.printStackTrace();
        }
    }
}
