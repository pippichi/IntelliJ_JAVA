package io_对象序列化_反序列化;

import java.io.*;
import java.util.Arrays;

/**
 * 引用类型(对象) 保留数据+类型
 * 反序列化 输入流:ObjectInputStream  readObject()
 * 序列化  输出流:ObjectOutputStream   writeObject()
 *
 * 注意:
 * 1)先序列化后反序列化 ; 反序列化顺序必须与序列化一致
 * 2)不是所有的对象都可以序列化， 要借助java.io.Serializable
 *      不是所有的属性都需要序列化，不想序列化的属性用transient
 */
public class 引用类型_对象_保留数据_类型 {
    public static void main(String[] args) {
        try {
            seri("D:/Java test/test/employee.txt");
            read("D:/Java test/test/employee.txt");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    public static void seri(String path) throws IOException {
        Employee emp = new Employee("bjsxt",100000);
        int[] arr = {1,2,3,4,2};
        File file = new File(path);
        ObjectOutputStream dos = new ObjectOutputStream(
                new BufferedOutputStream(
                        new FileOutputStream(file)
                )
        );
        dos.writeObject(emp);
        dos.writeObject(arr);
        dos.flush();
        dos.close();
    }
    public static void read(String path) throws IOException, ClassNotFoundException {
        File file = new File(path);
        ObjectInputStream ois = new ObjectInputStream(
                new BufferedInputStream(
                        new FileInputStream(file)
                )
        );
        Object obj = ois.readObject();
        if(obj instanceof Employee){
            Employee emp = (Employee)obj;
            System.out.println(emp.getName()+"\n"+emp.getSalary());
        }
        obj = ois.readObject();
        if(obj instanceof int[]){
            int[] temp = (int[])obj;
            System.out.println(Arrays.toString(temp));
        }
        if(ois!=null){
            ois.close();
        }
    }
}
