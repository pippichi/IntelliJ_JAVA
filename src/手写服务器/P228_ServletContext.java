package 手写服务器;

import java.util.HashMap;
import java.util.Map;

/**
 * 上下文
 */
public class P228_ServletContext {
//    为每一个servlet取个别名
//    login -->com.bjsxt.server.demo03.LoginServlet
    private Map<String,String> servlet;
//    url -->login
//        /log --> login
//        /login -->login
    private Map<String,String> mapping;

    P228_ServletContext() {
        servlet = new HashMap<>();
        mapping = new HashMap<>();
    }

    public Map<String,String> getServlet() {
        return servlet;
    }

    public void setServlet(Map<String, String> servlet) {
        this.servlet = servlet;
    }

    public Map<String, String> getMapping() {
        return mapping;
    }

    public void setMapping(Map<String, String> mapping) {
        this.mapping = mapping;
    }
}
