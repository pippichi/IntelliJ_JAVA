package 正则表达式;
/**
 * 测试正则表达式对象的基本用法
 */

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Demo01 {
    public static void main(String[] args) {
        //在这个字符串：asdfsafas2314241，是否符合指定的正则表达式：\w+

        //表达式对象
        Pattern p = Pattern.compile("\\w+");

        //创建Matcher对象
        Matcher m = p.matcher("asdfsafas2314&241");

        boolean yesorno = m.matches();//尝试将整个字符序列与该模式匹配
        System.out.println(yesorno);

        boolean yesorno1= m.find();//该方法扫描输入的序列，查找与该模式匹配的下一个子序列
        System.out.println(yesorno1);

        Matcher m1 = p.matcher("123&23_weq&&231qw");
        System.out.println(m1.find());//找到
        System.out.println(m1.group());//打印
        while(m1.find()){
            System.out.println(m1.group());//group()和group(0)都表示匹配整个字符串
            System.out.println(m1.group(0));
        }
    }
}
