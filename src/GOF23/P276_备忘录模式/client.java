package GOF23.P276_备忘录模式;

public class client {
    public static void main(String[] args) {
        CareTaker ct = new CareTaker();

        Emp emp = new Emp("q",11,21);
        System.out.println("第一次打印对象: "+emp.getEname()+"---"+emp.getAge()+"---"+emp.getSalary());

        ct.setMmt(emp.memento());

        emp.setAge(18);
        emp.setEname("y");
        emp.setSalary(10000);
        System.out.println("第二次打印对象: "+emp.getEname()+"---"+emp.getAge()+"---"+emp.getSalary());

        emp.recovery(ct.getMmt());  //恢复到备忘录对象保存的状态
        System.out.println("第三次打印对象: "+emp.getEname()+"---"+emp.getAge()+"---"+emp.getSalary());
    }
}
