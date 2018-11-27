package 自定义泛型_深入_无多态;

import com.sun.jdi.event.StepEvent;

public class 嵌套<T> {
    T stu;

    public static void main(String[] args){
        嵌套<Student<String>> room = new 嵌套<Student<String>>();
        room.stu = new Student<String>();
        Student<String> stu = room.stu;
        String score = stu.score;
        System.out.println(score);
    }
}
