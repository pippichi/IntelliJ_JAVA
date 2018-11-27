package Predicate和Consumer;

import org.junit.Test;
import 反射1.User;

import java.util.function.Consumer;

public class Consumer测试 {

    @Test
    //不使用lambda表达式
    public void testConsumer01(){
        User user = new User(13,01,"q");
        this.change(user);
        System.out.println(user.getUname());
    }
    private void change(User user){
        user.setUname("y");
    }

    @Test
    //使用lambda表达式
    public void testConsumer02(){
        User user = new User(13,02,"q");
        //接受一个参数
        Consumer<User> userConsumer = User->User.setUname("f");
        userConsumer.accept(user);
        System.out.println(user.getUname());
    }
}
