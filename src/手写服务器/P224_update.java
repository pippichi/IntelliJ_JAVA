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

public class P224_update {

    private ServerSocket server;
    public static final String CRLF = "\r\n";
    public static final String BLANK = " ";

    public static void main(String[] args) {
        P224_update server = new P224_update();
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
            //接收客户端的请求信息
            //请求
            P224_Request req = new P224_Request(client.getInputStream());

            //响应
            P223_Response rep = new P223_Response(client.getOutputStream());

            rep.println("<html><head><title>HTTP响应示例</title>");
            rep.println("</head><body>");
            rep.println("欢迎: ").println(req.getParameter("uname")).println("回来");
            rep.println("</body></html>");
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
