package io_对象序列化_反序列化;

/**
 * Serializable 是个空接口，空接口只是标识
 */
public class Employee implements java.io.Serializable{
    //不需要序列化
    private transient String name;
    private double salary;

    public Employee() {
    }

    public Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}
