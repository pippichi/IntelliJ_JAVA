package 手写服务器;

import java.util.HashMap;
import java.util.Map;

/**
 * 上下文
 */
public class P227_ServletContext {
//    为每一个servlet取个别名
//    login -->LoginServlet
    private Map<String,P227_Servlet> servlet;
//    url -->login
//        /log --> login
//        /login -->login
    private Map<String,String> mapping;

    P227_ServletContext() {
        servlet = new HashMap<>();
        mapping = new HashMap<>();
    }

    public Map<String, P227_Servlet> getServlet() {
        return servlet;
    }

    public void setServlet(Map<String, P227_Servlet> servlet) {
        this.servlet = servlet;
    }

    public Map<String, String> getMapping() {
        return mapping;
    }

    public void setMapping(Map<String, String> mapping) {
        this.mapping = mapping;
    }
}
