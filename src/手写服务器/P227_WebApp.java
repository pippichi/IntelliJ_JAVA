package 手写服务器;

import java.util.Map;

public class P227_WebApp {
    private static P227_ServletContext contxt;
    static {
        contxt = new P227_ServletContext();

        Map<String,String> mapping = contxt.getMapping();
        mapping.put("/login","login");
        mapping.put("/log","login");
        mapping.put("/reg","register");

        Map<String,P227_Servlet> servlet = contxt.getServlet();
        servlet.put("login",new P227_loginServlet());
        servlet.put("register",new P227_registerServlet());
    }

    public static P227_Servlet getServlet(String url){
        if((url==null)||(url=url.trim()).equals("")){
            return null;
        }
        return contxt.getServlet().get((contxt.getMapping().get(url)));
    }

}
