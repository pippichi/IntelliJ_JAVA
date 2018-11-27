package 手写服务器;

/**
 * 抽象成父类
 */
public abstract class P227_Servlet {
    public void service(P224_Request req,P223_Response rep) throws Exception{
        this.doGet(req, rep);
        this.doPost(req, rep);
    }
    public abstract void doGet(P224_Request req,P223_Response rep) throws Exception;
    public abstract void doPost(P224_Request req,P223_Response rep) throws Exception;
}
