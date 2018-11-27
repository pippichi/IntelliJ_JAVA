package 手写服务器.P231_server;

import 手写服务器.*;

import java.io.IOException;
import java.net.Socket;

/**
 * 一个请求与响应 就一个此对象
 */
public class P228_Dispatcher implements Runnable{
    private Socket client;
    private P224_Request req;
    private P223_Response rep;
    private int code = 200;

    P228_Dispatcher(Socket client){
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
        try {
            P227_Servlet serv = P227_WebApp.getServlet(req.getUrl());
            if(serv==null){
                this.code=404;//找不到处理
            }else {
                serv.service(req, rep);
            }
            rep.pushToClient(code); //推送到客户端
        } catch (Exception e) {
//            e.printStackTrace();
            this.code = 500;
        }
        FileUtil.closeAll(client);
    }
}
