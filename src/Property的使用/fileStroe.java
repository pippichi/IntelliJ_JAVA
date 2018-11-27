package Property的使用;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class fileStroe {
    public static void main(String[] args) throws IOException {
        Properties pro = new Properties();
        pro.setProperty("driver","html52");
        pro.setProperty("driver1","html15");
        pro.setProperty("driver2","html5");
        pro.setProperty("driver3","html54");
        System.out.println(pro.values());
        File file = new File("D:/Java test/test/Property.properties");
        File file1 = new File("src/Property的使用/Property.xml");
        try {
            pro.store(new FileOutputStream(file),"qyf");
            pro.storeToXML(new FileOutputStream(file1),"qyf");
        } catch (IOException e) {
            e.printStackTrace();
        }
        List<String> list = new ArrayList<>();
        list.add("src/Property的使用/Property.xml");
        list.add("src/Property的使用/Property1.xml");
        list.add("src/Property的使用/Property2.xml");
        for(int i=0;i<list.size();i++){
            pro.loadFromXML(new FileInputStream(new File(list.get(i))));
            pro.storeToXML(new FileOutputStream(new File("src/Property的使用/Property4.xml"),true),"qyfnig");
        }

        String str = pro.getProperty("driver1","html");
        System.out.println(str);
    }
}
