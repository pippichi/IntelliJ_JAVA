package 强_软_弱_虚_引用的使用;

import java.util.EnumMap;

/**
 * EnumMap:要求键为枚举
 */
public class EnumMapDemo {
    public static void main(String[] args) {
        //()中指定枚举class对象
        EnumMap<Season,String> map = new EnumMap<>(Season.class);
        map.put(Season.SPRING,"困");
        map.put(Season.SUMMER,"乏");
        map.put(Season.AUTUMN,"累");
        map.put(Season.WINTER,"眠");
        System.out.println(map.size());
    }
}
enum Season{
    SPRING,SUMMER,AUTUMN,WINTER
}
