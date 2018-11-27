package Map经典存储_分拣思路;

import java.util.ArrayList;
import java.util.List;

public class ClassRoom{
    private String num;
    private List<Student> stu;
    private double total;

    public ClassRoom(String num) {
        this();
        this.num = num;
    }

    public ClassRoom() {
        stu = new ArrayList<>();
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public List<Student> getStu() {
        return stu;
    }

    public void setStu(List<Student> stu) {
        this.stu = stu;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public double getAveScore(){ return total/stu.size();}
}