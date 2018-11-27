package Property的使用;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * 使用Property输出到文件
 * 这个文件也叫资源配置文件：
 *
 * 1、.properties
 *    store(OutputStream out,String comments)
 *    store(Writer writer,String comments)
 * 2、.xml
 *    storeToXML(OutputStream out,String comments)
 *    storeToXML(OutputStream out,String comments,String encoding)
 */
public class Demo02 {
    public static void main(String[] args)  {
        //创建对象
        Properties pro = new Properties();
        //存储
        pro.setProperty("driver", "oracle.jdbc.driver.OracleDriver");
        pro.setProperty("url", "jdbc:oracle:thin:@localhost:1521:orcl");
        pro.setProperty("user", "scott");
        pro.setProperty("pwd", "tiger");
        File file = new File("C:/Users/HASEE/Desktop/db.properties");
        File file1 = new File("C:/Users/HASEE/Desktop/db.xml");
        File file2 = new File("db.xml");
        //存储到e:/others    绝对路径 盘符：
        try {
            pro.store(new FileOutputStream(file), "db配置");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        file.delete();
        try {
            pro.storeToXML(new FileOutputStream(file1),"db");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }catch (IOException e) {
            e.printStackTrace();
        }
        file1.delete();
        //使用相对路径
        try {
            pro.storeToXML(new FileOutputStream(file2),"db");
        } catch (IOException e) {
            e.printStackTrace();
        }
        file2.delete();
        try {
            pro.store(new FileOutputStream(new File("src/Property的使用/db.properties")), "db配置");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
