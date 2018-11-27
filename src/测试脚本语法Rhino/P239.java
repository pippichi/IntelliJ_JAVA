package 测试脚本语法Rhino;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.List;

/**
 * 测试脚本引擎执行JavaScript代码
 */
public class P239 {
    public static void main(String[] args) throws ScriptException, NoSuchMethodException, IOException {
        //获得脚本引擎对象
        ScriptEngineManager sem = new ScriptEngineManager();
        ScriptEngine engine = sem.getEngineByName("javascript");

        //定义变量，存储到引擎上下文中
        engine.put("msg","q is a bad man!");
        String str = "var user = {name:'q',age:13,schools:['dax','zhej']};";
        str += "print(msg);";

        //执行脚本
        engine.eval(str);
        engine.eval("msg='q is good!'");

        System.out.println(engine.get("msg"));
        System.out.println("####################");

        //定义函数
        engine.eval("function add(a,b){var sum = a+b;return sum;}");
        //取得调用接口
        Invocable jsInvocable = (Invocable)engine;
        //执行脚本中定义的方法
        Object result = jsInvocable.invokeFunction("add",new Object[]{13,20});
        System.out.println(result);

        //导入其他Java包,使用其他包中的Java类，若要深入了解细节，可以详细学习Rhino的语法。
        String jsCode = "var list = java.util.Arrays.asList([\"q\",\"e\",\"f\"]);";
        engine.eval(jsCode);

        List<String> list = (List<String>)engine.get("list");
        list.forEach(x-> System.out.println(x));

        //执行一个js文件(我们将js至于项目的src下即可)
        URL url = P239.class.getClassLoader().getResource("test.js");
        FileReader fr = new FileReader(url.getPath());
        engine.eval(fr);
        fr.close(); //实际使用时用try catch finally

    }
}
