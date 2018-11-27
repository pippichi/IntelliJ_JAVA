package Function库的使用;

import java.util.function.Function;

//        apply基本应用
//字符串长度记录返回
public class MyFunction implements Function<String,Integer> {

    @Override
    public Integer apply(String s) {
        return s.length();
    }
}
