package GOF23.P256_反序列化实现深复制.P255_Prototype;

import java.io.*;
import java.util.Date;

/**
 * 原型模式(深复制，使用序列化和反序列化的方式实现深复制)
 * 测试原型模式
 */
public class client {
    public static void main(String[] args) throws CloneNotSupportedException, IOException, ClassNotFoundException {
        Date date = new Date(12312321331L);
        Sheep s1 = new Sheep("shaoli",date);
        System.out.println(s1);
        System.out.println(s1.getBirthday());

//        Sheep s2 = (Sheep) s1.clone();
//        使用序列化和反序列化实现深复制
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(baos);
        oos.writeObject(s1);
        byte[] bytes = baos.toByteArray();
        ByteArrayInputStream bais = new ByteArrayInputStream(bytes);
        ObjectInputStream ois = new ObjectInputStream(bais);
        Sheep s2 = (Sheep)ois.readObject(); //克隆好的对象!


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
