package 注解Annotation;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("all")
public class Demo /*extends Object*/{

    @Override
    public String toString(){
        return "";
    }

    @Deprecated//表示过时的方法
    public static void test001(){}

    @SuppressWarnings("all") //（）里面可以写 deprecation,则可以抑制过时的警告；还有unchecked、fallthrough、path、serial、finally、all
    public static void test002(){
        List list = new ArrayList();//这里会报警告
        List list2 = new ArrayList();//这里也会报警告
    }

    @SuppressWarnings({"deprecation","unchecked"})//此注解（）中可以写多个
    public static void test003(){}

    public static void main(String[] args) {
        test001();
    }
}
