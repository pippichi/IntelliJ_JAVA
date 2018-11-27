package 手写服务器.P231_servlet;

import 手写服务器.P223_Response;
import 手写服务器.P224_Request;

public class LoginWeb extends P228_Servlet{
    @Override
    public void doGet(P224_Request req, P223_Response rep) throws Exception {
        rep.println("success...");
    }

    @Override
    public void doPost(P224_Request req, P223_Response rep) throws Exception {

    }
}
