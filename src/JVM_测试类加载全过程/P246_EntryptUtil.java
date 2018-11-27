package JVM_测试类加载全过程;

import java.io.*;

/**
 * 加密工具
 */
public class P246_EntryptUtil {

    public static void main(String[] args) {
        encrypt(new File("D:\\IntelliJ_JAVA\\src\\test.js"),new File("D:\\IntelliJ_JAVA\\src\\test1.js"));
    }

    public static void encrypt(File src,File dest){
        FileInputStream fis = null;
        FileOutputStream fos = null;

        try {
            fis = new FileInputStream(src);
            fos = new FileOutputStream(dest);

            int temp = 0;
            while((temp=fis.read())!=-1)
                fos.write(temp^0xff);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(fos!=null) {
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(fis!=null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
