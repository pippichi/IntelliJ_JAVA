package net;

import java.io.Closeable;
import java.io.IOException;

/**
 * 关闭流的方法
 */
public class P218_closeUtil {
    public static <T extends Closeable> void closeAll(T... io){
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
