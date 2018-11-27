package 手写服务器.P231_server;

import org.xml.sax.SAXException;
import 手写服务器.P231_servlet.P228_Servlet;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Map;

public class P228_WebApp {
    private static P228_ServletContext contxt;
    static {


        //获取解析工厂
        SAXParserFactory factory = SAXParserFactory.newInstance();
        //获取解析器
        SAXParser sax = null;
        try {
            P230_P228_WebHandler web = new P230_P228_WebHandler();
            sax = factory.newSAXParser();
            sax.parse(Thread.currentThread().getContextClassLoader()
                    .getResourceAsStream("手写服务器\\P231_Info\\P229_xml.xml"),web);

            //将List转成Map
            contxt = new P228_ServletContext();

            Map<String,String> mapping = contxt.getServlet();
            //servlet-name  servlet-class
            web.getEntityList().forEach(x->mapping.put(x.getName(),x.getClz()));

            //url-pattern servlet-name
            Map<String,String> servlet = contxt.getMapping();
            for(P230_Mapping mapp:web.getMappingList()){
                List<String> urls = mapp.getUrlPattern();
                urls.forEach(x->servlet.put(x,mapp.getName()));
            }
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        //指定xml+处理器

        contxt = new P228_ServletContext();

        Map<String,String> mapping = contxt.getMapping();
        mapping.put("/login","login");
        mapping.put("/log","login");
        mapping.put("/reg","register");

        Map<String,String> servlet = contxt.getServlet();
        servlet.put("login","手写服务器.P228_loginServlet");
        servlet.put("register","手写服务器.P228_registerServlet");
    }

    public static P228_Servlet getServlet(String url){
        if((url==null)||(url=url.trim()).equals("")){
            return null;
        }
        //根据字符串(完整路径)创建对象

        //return contxt.getServlet().get((contxt.getMapping().get(url)));
        String name = contxt.getServlet().get((contxt.getMapping().get(url)));
        try {
            return (P228_Servlet)Class.forName(name).getDeclaredConstructor().newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}
