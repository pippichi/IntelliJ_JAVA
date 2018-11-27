package 手写服务器.P231_server;

/*
 <servlet>
        <servlet-name>login</servlet-name>
        <servlet-class>手写服务器.P228_loginServlet</servlet-class>
    </servlet>
 */
public class P230_Entity {
    private String name;
    private String clz;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getClz() {
        return clz;
    }

    public void setClz(String clz) {
        this.clz = clz;
    }
}
