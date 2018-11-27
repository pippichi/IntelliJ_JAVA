package Junit中接口;

import org.junit.Test;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 最重要的注解解析框架
 */
public class ParseJunit {
    public void parseMethod(Class clazz) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Object obj = clazz.getDeclaredConstructor().newInstance();
        Method[] methods = clazz.getDeclaredMethods();

        //Before的注解只有一个，直接在外面定义一个Method类型的变量
        Method methodsBefore = null;
        Method[] methodsTest = null;
        int index = 0;
        Method methodsAfter = null;

        //循环所有的方法
        for (Method m:methods){
            //得到方法上的所有注解，因为不确定是Before还是After、Test，不能直接根据class得到注解
            Annotation[] myJunitTest = m.getDeclaredAnnotations();
            //循环所有的注解，根据名字匹配
            for(int i=0;i<myJunitTest.length;i++){
                //根据名字匹配注解的类型
                if(myJunitTest[0].annotationType().getSimpleName().endsWith("Before")){
                    methodsBefore = m;
                }else if(myJunitTest[0].annotationType().getSimpleName().endsWith("Test")){
                    //如果为Test，判断这个数组是否为空，否：存入定义好的数组中，然后下标加一
                    if(methodsTest==null){
                        //是，新生成一个数组，然后将m存入
                        methodsTest = new Method[methods.length];
                    }
                    methodsTest[index] = m;
                    index++;
                }else if(myJunitTest[0].annotationType().getSimpleName().endsWith("After")){
                    methodsAfter = m;
                }
            }
        }

        //1、先执行Before注解的方法
        if(methodsBefore!=null){
            methodsBefore.invoke(obj);
        }
        //2、执行Test注解的数组中的方法
        if(methodsTest!=null&&methodsTest.length>0){
            for(Method m:methodsTest){
                if(m!=null){
                    m.invoke(obj);
                }
            }
        }
        //3、最后执行After注解的方法
        if(methodsAfter!=null){
            methodsAfter.invoke(obj);
        }
    }

    /**
     * @throws InvocationTargetException
     * @throws NoSuchMethodException
     * @throws InstantiationException
     * @throws IllegalAccessException
     */
    @Test
    public void testApp() throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        ParseJunit pj = new ParseJunit();
        pj.parseMethod(MyJunitTest.class);
    }
}
