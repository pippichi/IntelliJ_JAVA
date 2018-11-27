package 手写服务器;

public class P228_loginServlet extends P227_Servlet{
    @Override
    public void doGet(P224_Request req,P223_Response rep) throws Exception {
        String name = req.getParameter("uname");
        String pwd = req.getParameter("pwd");

        if(login(name,pwd)){
            rep.println("登陆成功！");
            rep.println("<html><head><title>欢迎回来</title>");
            rep.println("</head><body>");
            rep.println("欢迎: ").println(req.getParameter("uname")).println("回来");
            rep.println("</body></html>");
        }else{
            rep.println("登陆失败!");
        }


    }

    public boolean login(String name,String pwd){
        return name.equals("q")&&pwd.equals("123345");
    }

    @Override
    public void doPost(P224_Request req,P223_Response rep) throws Exception {

    }
}
