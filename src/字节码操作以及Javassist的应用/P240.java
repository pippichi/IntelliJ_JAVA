package 字节码操作以及Javassist的应用;

import javassist.*;

import java.io.IOException;

/**
 * 测试使用javassist生成一个新的类
 */
public class P240 {
    public static void main(String[] args) throws CannotCompileException, IOException, NotFoundException {
        ClassPool pool = ClassPool.getDefault();
        //建立新类
        CtClass cc =pool.makeClass("字节码操作以及Javassist的应用.Emp");

        //创建属性
        CtField f1 = CtField.make("private int empNum=010;",cc);
        CtField f2 = CtField.make("private String empName;",cc);
        cc.addField(f1);
        cc.addField(f2);

        //创建方法
        CtMethod m1 = CtMethod.make("public int getEmpNum() {\n" +
                "        return empNum;\n" +
                "    }",cc);
        CtMethod m2 = CtMethod.make("public void setEmpNum(int empNum) {\n" +
                "        this.empNum = empNum;\n" +
                "    }",cc);
        cc.addMethod(m1);
        cc.addMethod(m2);

        //添加构造器
        CtConstructor c1 = new CtConstructor(new CtClass[]{CtClass.intType,pool.get("java.lang.String")},cc);
        c1.setBody("{ this.empNum = empNum;\n" +
                "        this.empName = empName;}");
        cc.addConstructor(c1);
        cc.writeFile(".\\");//写入上面构造好的类

    }
}
