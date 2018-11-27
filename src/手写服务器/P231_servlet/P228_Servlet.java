package 手写服务器.P231_servlet;

import 手写服务器.P223_Response;
import 手写服务器.P224_Request;

/**
 * 抽象成父类
 */
public abstract class P228_Servlet {
    public void service(P224_Request req,P223_Response rep) throws Exception{
        this.doGet(req, rep);
        this.doPost(req, rep);
    }
    protected abstract void doGet(P224_Request req,P223_Response rep) throws Exception;
    protected abstract void doPost(P224_Request req,P223_Response rep) throws Exception;
}
