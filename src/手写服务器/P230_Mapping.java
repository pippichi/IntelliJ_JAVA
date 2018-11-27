package 手写服务器;

import java.util.ArrayList;
import java.util.List;

/*
 <servlet-mapping>
        <servlet-name>login</servlet-name>
        <url-pattern>/login</url-pattern>   <!--"/"是指相对路径-->
    </servlet-mapping>
    <servlet-mapping>
        <servlet-name>login</servlet-name>
        <url-pattern>/log</url-pattern>
    </servlet-mapping>
 */
public class P230_Mapping {
    private String name;
    private List<String> urlPattern;

    public P230_Mapping(){
        urlPattern = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getUrlPattern() {
        return urlPattern;
    }

    public void setUrlPattern(List<String> urlPattern) {
        this.urlPattern = urlPattern;
    }
}
