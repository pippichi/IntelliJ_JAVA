package 正则表达式;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 测试正则表达式对象中分组处理
 */
public class Demo02 {
    public static void main(String[] args) {

        //表达式对象
        Pattern p = Pattern.compile("([a-z]+)([0-9]+)");//第一个括号是group(1),第二个括号是group(2)

        //创建Matcher对象
        Matcher m = p.matcher("aa232**ssd445*sds223");

        System.out.println(m.find());
        System.out.println(m.group());

        while(m.find()){
            System.out.println(m.group(1));
            System.out.println(m.group(2));
        }
    }
}
