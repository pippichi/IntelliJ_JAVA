package 字节码操作以及Javassist的应用;

import javassist.*;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * 处理类
 */
public class P241 {
    public static void test01() throws NotFoundException, IOException, CannotCompileException {
        ClassPool pool = ClassPool.getDefault();
        CtClass cc = pool.get("字节码操作以及Javassist的应用.Emp");

        //获取字节码信息
        byte[] bytes = cc.toBytecode();
        System.out.println(Arrays.toString(bytes));

        System.out.println(cc.getName());//获取类名
        System.out.println(cc.getSimpleName());//简要类名
        System.out.println(cc.getSuperclass());//父类
        System.out.println(cc.getInterfaces());//接口
    }

    /**
     * 测试产生新的方法
     */
    public static void test02() throws NotFoundException, CannotCompileException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
//        ClassPool pool = ClassPool.getDefault();
//        CtClass cc = pool.get("字节码操作以及Javassist的应用.Emp");

//        CtMethod m1 = CtMethod.make(" public int getEmpNum() {\n" +
//                "        return empNum;\n" +
//                "    }",cc);

        //给CtClass对象解冻
//        cc.defrost();

//        CtMethod m1 = new CtMethod(CtClass.intType,"getEmpNumA",new CtClass[]{},cc);
//        m1.setModifiers(Modifier.PUBLIC);
//        m1.setBody("{System.out.println(\"complete\");return empNum;}");
//        cc.addMethod(m1);

        ClassPool pool2 = ClassPool.getDefault();
        CtClass cc2 = pool2.get("字节码操作以及Javassist的应用.Emp");
        cc2.defrost();
        CtMethod m2 = new CtMethod(CtClass.intType,"addA",new CtClass[]{CtClass.intType,CtClass.intType},cc2);
        m2.setModifiers(Modifier.PUBLIC);
        m2.setBody("{System.out.println(\"complete\");return $1+$2;}"); //这里$0表示this,$1表示第一个参数,$2表示第二个参数
        cc2.addMethod(m2);

        //通过反射调用新生成的方法
//        Class clazz = cc.toClass();
//        Object obj = clazz.getDeclaredConstructor(int.class,String.class).newInstance(13,"nv"); //有参构造
//        Method method = clazz.getDeclaredMethod("getEmpNumA");
//        Object result = method.invoke(obj);
//        System.out.println(result);

        Class clazz2 = cc2.toClass();
        Object obj2 = clazz2.getDeclaredConstructor(int.class,String.class).newInstance(12,"nan");
        Method method2 = clazz2.getDeclaredMethod("addA",int.class,int.class);
        Object result2 = method2.invoke(obj2,13,2);
        System.out.println(result2);
    }

    /**
     * 修改已有的方法，修改方法体
     * @throws NotFoundException
     * @throws CannotCompileException
     * @throws NoSuchMethodException
     * @throws InvocationTargetException
     * @throws IllegalAccessException
     * @throws InstantiationException
     */
    public static void test03() throws NotFoundException, CannotCompileException, NoSuchMethodException, InvocationTargetException, IllegalAccessException, InstantiationException {
        ClassPool pool = ClassPool.getDefault();
        CtClass cc = pool.get("字节码操作以及Javassist的应用.Emp");
        cc.defrost();
        cc.freeze();//冻住cc,让它不能用
        CtMethod cm =  cc.getDeclaredMethod("sayHello",new CtClass[]{CtClass.intType});
        cm.insertBefore("System.out.println($1);System.out.println(\"start\");");
        cm.insertAfter("System.out.println(\"end!\");");
//        在某一行之前加
        cm.insertAt(58,"int b = 0;System.out.println(\"b=\"+b);");


        //通过反射调用新生成的方法
        Class clazz = cc.toClass();
        Object obj = clazz.getDeclaredConstructor(int.class,String.class).newInstance(12,"nv");
        Method m = clazz.getDeclaredMethod("sayHello",int.class);
        Object result = m.invoke(obj,13);
        System.out.println(result);
    }

    /**
     * 加入新属性
     * 获得指定属性
     * @throws NotFoundException
     * @throws CannotCompileException
     */
    public static void test04() throws NotFoundException, CannotCompileException {
        ClassPool pool = ClassPool.getDefault();
        CtClass cc = pool.get("字节码操作以及Javassist的应用.Emp");

        //以前的改法:
//        CtField f1 = CtField.make("private int empNum;",cc);
        CtField f1 = new CtField(CtClass.intType,"salary",cc);
        f1.setModifiers(Modifier.PRIVATE);
        cc.addField(f1,"100");//第二个参数是默认值

        //给salary加getter setter方法
        cc.addMethod(CtNewMethod.getter("getSalary",f1));
        cc.addMethod(CtNewMethod.setter("setSalary",f1));

        //获取指定属性
//        cc.getDeclaredField("empNum");
    }

    /**
     * 构造器处理
     */
    public static void test05() throws NotFoundException {
        ClassPool pool = ClassPool.getDefault();
        CtClass cc = pool.get("字节码操作以及Javassist的应用.Emp");

        CtConstructor[] constructor = cc.getDeclaredConstructors();
        for (CtConstructor c:constructor){
            System.out.println(c.getLongName());
            //添加方法
//            c.insertAfter();
//            c.insertBefore();
//            c.insertAt();
        }
    }

    /**
     * 获取Annotations
     */
    public static void test06() throws NotFoundException, ClassNotFoundException {
        CtClass cc = ClassPool.getDefault().get("字节码操作以及Javassist的应用.Emp");
        Object[] all = cc.getAnnotations();
        EAno ea = (EAno)all[0];
        String name = ea.name();
        int year = ea.year();
        System.out.println("name="+name+"\nyear="+year);
    }

    public static void main(String[] args) throws IOException, CannotCompileException, NotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException, ClassNotFoundException {
        //test01();
        //test02();
        //test03();
        //test04();
        //test05();
        test06();
    }
}
