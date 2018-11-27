package 自己写的栈_涉及到双端队列;

public class MyStackApp {
    public static void main(String[] args) {
        MyStack<String> backHistory = new MyStack<>(3);
        backHistory.push("q4");
        backHistory.push("q3");
        backHistory.push("q2");
        backHistory.push("q1");
        System.out.println(backHistory.size());

        String item = null;
        while((item=backHistory.pop())!=null){
            System.out.println(item);
        }
    }
}
