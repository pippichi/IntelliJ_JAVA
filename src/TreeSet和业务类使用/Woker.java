package TreeSet和业务类使用;

import java.util.TreeSet;

public class Woker implements java.lang.Comparable<Woker>{
    private String type;
    private double salary;

    public static void main(String[] args) {
        TreeSet<Woker> tree = new TreeSet<>();
        addWoker(tree);
        System.out.println(tree);
    }
    public static void addWoker(TreeSet<Woker>personList){
        personList.add(new Woker("qyf",100));
        personList.add(new Woker("qyf1",170));
        personList.add(new Woker("qyf2",60));
        personList.add(new Woker("qyf3",300));
        personList.add(new Woker("qyf4",202));
    }
    public Woker(String type, double salary) {
        this.type = type;
        this.salary = salary;
    }

    public Woker() {
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public int compareTo(Woker o) {
        return salary>o.salary?1:salary==o.salary?0:-1;
}

    @Override
    public String toString(){
        return type + " ,salary is " + salary + "\n";
    }
}
