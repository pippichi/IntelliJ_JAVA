package 反射;

import 反射1.SxtField;
import 反射1.SxtTable;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

public class Demo06 {
    public static void main(String[] args) {

        try{
            Class clazz = Class.forName("反射1.SxtStudent");

            //获得类的所有有效注解
            Annotation[] annotations = clazz.getAnnotations();
            for(Annotation temp:annotations){
                System.out.println(temp);
            }
            //获得类的指定的注解
            SxtTable st = (SxtTable)clazz.getAnnotation(SxtTable.class);
            System.out.println(st.value());

            //获得类的属性的注解
            Field f = clazz.getDeclaredField("studentName");
            SxtField sf = f.getAnnotation(SxtField.class);
            System.out.println(sf.columnName()+" "+sf.type()+" "+sf.length());

            //根据获得的表名、字段的信息，拼出DDL语句，然后，使用JDBC执行这个SQL，在数据库中生成相关的表


        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
    }
}
