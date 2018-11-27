package 动态编译;

import java.lang.reflect.InvocationTargetException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;

/**
 * 使用URLClassLoader
 */
public class 通过反射运行编译好的类 {
    public static void main(String[] args) {
        try{
            URL[] urls = new URL[]{new URL("file:\\"+"D:\\IntelliJ_JAVA\\src\\")};
            URLClassLoader loader = new URLClassLoader(urls);
            Class c = loader.loadClass("System_out_in的使用.System_err");
            //调用main方法
//            c.getMethod("main",String[].class).invoke(null,new String[]{"aa","bb"});
//            由于可变参数是JDK5.0之后才有。因此上面代码会编译成invoke(null,"aa","bb");这就造成参数不匹配问题，因此一定要加Object
            c.getMethod("main",String[].class).invoke(null,(Object)new String[]{});

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }
}
