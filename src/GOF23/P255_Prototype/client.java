package GOF23.P255_Prototype;

import java.util.Date;

/**
 * 测试原型模式
 */
public class client {
    public static void main(String[] args) throws CloneNotSupportedException {
        Date date = new Date(12312321331L);
        Sheep s1 = new Sheep("shaoli",date);
        System.out.println(s1);
        System.out.println(s1.getBirthday());

        Sheep s2 = (Sheep) s1.clone();
        System.out.println(s2);
        System.out.println(s2.getBirthday());

        date.setTime(123321123123L);
        s1.setSname("qq");
        System.out.println(s2.getBirthday());
        System.out.println(s1.getBirthday());
        System.out.println(s1.getSname());
        System.out.println(s2.getSname());
    }
}
