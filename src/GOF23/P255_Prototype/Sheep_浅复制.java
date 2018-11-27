package GOF23.P255_Prototype;

import java.util.Date;

/**
 * 浅复制
 */
public class Sheep_浅复制 implements Cloneable{
    private String sname;
    private Date birthday;

    public Sheep_浅复制(String sname, Date birthday) {
        this.sname = sname;
        this.birthday = birthday;
    }

    public Sheep_浅复制() {
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException{
        return super.clone();//直接调用Object的clone()
    }
}
