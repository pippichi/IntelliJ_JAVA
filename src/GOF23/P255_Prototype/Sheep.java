package GOF23.P255_Prototype;

import java.util.Date;

/**
 * 深复制
 */
public class Sheep implements Cloneable{
    private String sname;
    private Date birthday;

    public Sheep(String sname, Date birthday) {
        this.sname = sname;
        this.birthday = birthday;
    }

    public Sheep() {
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
        Object obj = null;//直接调用Object的clone()
        obj = super.clone();
        ((Sheep)obj).birthday = (Date)birthday.clone();
        return obj;
    }
}
