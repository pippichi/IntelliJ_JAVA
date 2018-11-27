package 手写服务器;

import java.io.Closeable;
import java.io.IOException;

/**
 * 工具类关闭流
 * 可变参数：...  只能放在形参最后一个位置,处理方式与数组一致
 */
public class FileUtil {
    /*Closeable...表示参数个数随意指定，但是类型必须是Closeable的*/
    public static void close(/* String info,*/Closeable...io) {
        for(Closeable temp:io){
            if(temp!=null){
                try {
                    temp.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * 使用泛型方法
     */
    public static <T extends Closeable> void closeAll(T...io){
        for(T temp:io){
            if(temp!=null){
                try {
                    temp.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
