package 反射1;

public class User {
    private int age;
    private String uname;
    private int id;

    public User(int age, int id,String uname) {
        this.age = age;
        this.uname = uname;
        this.id = id;
    }

    public User() {
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
