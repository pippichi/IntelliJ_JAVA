package 手写服务器;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 创建服务器
 *
 * 1、请求
 * 2、响应
 */

public class P226_P224 {

    private ServerSocket server;
    public static final String CRLF = "\r\n";
    public static final String BLANK = " ";

    public static void main(String[] args) {
        P226_P224 server = new P226_P224();
        server.start();
    }

    /**
     * 启动方法
     */
    public void start(){
        try {
            server = new ServerSocket(8888);

            this.receive();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 接收客户端
     */
    private void receive(){
        try {
            Socket client = server.accept();
            P226_Servlet serv = new P226_Servlet();
            P224_Request req = new P224_Request(client.getInputStream());
            P223_Response rep = new P223_Response(client.getOutputStream());
            serv.service(req,rep);
            rep.pushToClient(200);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 停止服务器
     */
    public void stop(){

    }
}
