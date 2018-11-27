package 手写服务器;

import java.io.IOException;
import java.net.Socket;

/**
 * 一个请求与响应 就一个此对象
 */
public class P226_Dispatcher implements Runnable{
    private Socket client;
    private P224_Request req;
    private P223_Response rep;
    private int code = 200;

    public P226_Dispatcher(Socket client){
        this.client = client;
        try {
            req = new P224_Request(client.getInputStream());
            rep = new P223_Response(client.getOutputStream());
        } catch (IOException e) {
            //e.printStackTrace();
            code = 500;
            return;
        }
    }

    @Override
    public void run() {
        P226_Servlet serv = new P226_Servlet();
        serv.service(req,rep);
        rep.pushToClient(code); //推送到客户端
        FileUtil.closeAll(client);
    }
}
