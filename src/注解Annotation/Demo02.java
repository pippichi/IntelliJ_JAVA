package 注解Annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

@Target(value = {ElementType.METHOD,ElementType.TYPE})
public @interface Demo02 {
    String value();
}
