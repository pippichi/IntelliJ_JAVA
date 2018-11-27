package 注解Annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(value = {ElementType.METHOD,ElementType.TYPE}) //意味着此注解只能用在方法前面
@Retention(RetentionPolicy.RUNTIME)//在运行时有效，RUNTIME可以被反射机制读取
public @interface Demo01 {
    String study() default ""; //类型+变量名+默认值
    int grades() default 0;
    int id() default -1;  //如果默认值取复数(-1)则表示不存在的含义
    String[] schools() default {"清华大学","浙江大学"};
}
