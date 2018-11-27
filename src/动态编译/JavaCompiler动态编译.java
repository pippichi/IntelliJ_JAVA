package 动态编译;

import javax.tools.JavaCompiler;
import javax.tools.ToolProvider;
import java.io.*;

/**
 * 通过JavaCompiler动态编译
 */
public class JavaCompiler动态编译 {
    public static int compileFile(String sourceFile){
        //动态编译
        JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
//        第一个参数:为Java编译器提供参数
//        第二个参数:得到Java编译器的输出信息
//        第三个参数:接受编译器的错误信息
//        第四个参数:可变参数(是一个String数组)能传入一个或多个Java源文件
//        返回值:0表示编译成功，非0表示编译失败
        int result = compiler.run(null,null,null,sourceFile);
        System.out.println(result==0?"编译成功":"编译失败");
        return result;
    }

    public static void main(String[] args) throws IOException, InterruptedException {
        compileFile("d:/IntelliJ_JAVA/src/net/P209_ip.java");
        IOCompileFile();
    }
//    通过IO流操作，将字符串存储成一个临时文件，然后动态调用编译方法！
    public static int IOCompileFile() throws IOException, InterruptedException {


        //将字符串存储成一个临时文件
        File file = File.createTempFile("Hello",".java",new File("."));
        BufferedWriter br = new BufferedWriter(
                new OutputStreamWriter(
                        new FileOutputStream(file)
                )
        );
        System.out.println(file.getName().substring(0,file.getName().length()-5));
        String str = "public class "+file.getName().substring(0,file.getName().length()-5)+" {" +
                "public static void main(String[] args){" +
                "System.out.println();" +
                "}" +
                "}";
        br.write(str);
        br.flush();
        br.close();
        Thread.sleep(1000);

        JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
        int result = compiler.run(null,null,null,file.getAbsolutePath());
        System.out.println(result==0?"编译成功":"编译失败");

        file.deleteOnExit();
        return result;
    }
}
