package Property的使用;
/**
 * 使用类相对路径读取配置文件
 * bin
 */

import java.io.IOException;
import java.util.Properties;

public class Demo04 {
    public static void main(String[] args) throws IOException {
        Properties pro = new Properties();
        //类相对路径的/bin   ;   文件名中 / 表示bin
        //pro.load(Demo04.class.getResourceAsStream("/Property的使用/db.properties"));

        //使用当前的类加载器  ;   文件名中 “ ” 表示bin
        pro.load(Thread.currentThread().getContextClassLoader().getResourceAsStream("Property的使用/db.properties"));
        System.out.println(pro.getProperty("url","qyf"));
    }
}
