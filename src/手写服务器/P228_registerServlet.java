package 手写服务器;

public class P228_registerServlet extends P227_Servlet{
    @Override
    public void doGet(P224_Request req, P223_Response rep) throws Exception {

    }

    @Override
    public void doPost(P224_Request req, P223_Response rep) throws Exception {
        rep.println("<html><head><title>返回注册</title>");
        rep.println("</head><body>");
        rep.println("你的用户名为: ").println(req.getParameter("uname"));
        rep.println("</body></html>");
    }
}
