package 正则表达式;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 网络爬虫取连接
 */
public class WebSpiderTest {
    public static void main(String[] args) {
        String str = getUrl("https://www.163.com/","gbk");

        //Pattern p = Pattern.compile("<a[\\s\\S]+?</a>");

        List<String> list = getHref(str,"href=\"([\\w\\s./:]+?)\"");
        list.stream().forEach(x-> System.out.println(x));
    }

    /**
     * 获得url对应页面源码内容
     * @param str1
     * @return
     */
    public static String getUrl(String str1,String charset){
        StringBuilder sb = new StringBuilder();
        try {
            URL url = new URL(str1);

            BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream(), Charset.forName(charset)));

            String str = "";
            while((str=reader.readLine())!=null){
                sb.append(str);
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sb.toString();
    }

    public static List<String> getHref(String str,String regexStr){
        List<String> list = new ArrayList<>();

        Pattern p = Pattern.compile(regexStr);

        Matcher m = p.matcher(str);

        while(m.find()){
            list.add(m.group(1));
        }
        return list;
    }
}
