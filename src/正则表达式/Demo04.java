package 正则表达式;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 测试正则表达式对象的分割字符串操作
 */
public class Demo04 {
    public static void main(String[] args) {

        String str = "ads3123sad2314xad21";
        String[] arrs = str.split("\\d+");
        System.out.println(Arrays.toString(arrs));

    }
}
