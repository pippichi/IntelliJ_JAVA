package 注解Annotation;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;

/**
 * 使用反射读取注解的信息，模拟处理注解信息的流程
 */
public class Demo03 {
    public static void main(String[] args) {
        try {
            Class clazz = Class.forName("注解Annotation.SxtStudent");

            //获得类的所有有效注解
            Annotation[] annotations = clazz.getAnnotations();
            List<?> list = Arrays.asList(annotations);
            list.stream().forEach(x-> System.out.println(x));

            SxtTable st = (SxtTable)clazz.getAnnotation(SxtTable.class);
            System.out.println(st.value());

            Field fx = clazz.getDeclaredField("id");
            SxtField f = fx.getAnnotation(SxtField.class);
            System.out.println(f.columnName()+"  "+f.type()+"  "+f.length());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
    }
}
