package 字节码操作以及Javassist的应用;

class Father{
    private String gender;

    public Father(String gender) {
        this.gender = gender;
    }
    public Father(){
        this.gender = "nan";
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}

interface eat{
    String eatting();
}

@EAno(name = "Chiba",year = 2005)
public class Emp extends Father implements eat{
    private int empNum;
    private String empName;

    public int add(int a,int b){return a+b;}

    public int getEmpNum() {
        return empNum;
    }

    public void setEmpNum(int empNum) {
        this.empNum = empNum;
    }

    public String getEmpName() {
        return empName;
    }

    public Emp(String gender, int empNum, String empName) {
        super(gender);
        this.empNum = empNum;
        this.empName = empName;
    }

    public Emp(){}

    public Emp(int empNum, String empName) {
        this.empNum = empNum;
        this.empName = empName;
    }

    public void sayHello(int a){
        System.out.println("sayHello"+a);
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    @Override
    public String eatting() {
        return "eatting...";
    }
}
