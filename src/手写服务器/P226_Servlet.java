package 手写服务器;

public class P226_Servlet {
    public void service(P224_Request req,P223_Response rep){
        rep.println("<html><head><title>HTTP响应示例</title>");
        rep.println("</head><body>");
        rep.println("欢迎: ").println(req.getParameter("uname")).println("回来");
        rep.println("</body></html>");
    }
}
