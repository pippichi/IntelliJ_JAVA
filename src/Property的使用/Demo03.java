package Property的使用;

import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

/**
 * 使用Properties读取配置文件
 * 资源配置文件：
 * 1、load(InputStream in)
 * 2、load(Reader reader)
 * 3、loadFromXML(InputStream in)
 */
public class Demo03 {
    public static void main(String[] args) {
        Properties pro = new Properties();
        try {
            pro.load(new FileReader("db.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(pro.getProperty("user","qyf"));
        try {
            pro.load(new FileInputStream("db.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(pro.getProperty("url","qyf"));
        try {
            pro.loadFromXML(new FileInputStream("db.xml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(pro.getProperty("url","qyf"));
    }
}
