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

public class P223_update {

    private ServerSocket server;
    public static final String CRLF = "\r\n";
    public static final String BLANK = " ";

    public static void main(String[] args) {
        P223_update server = new P223_update();
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

            byte[] data = new byte[20480];
            int len = client.getInputStream().read(data);

            //接收客户端的请求信息
            String requestInfo = new String(data,0,len).trim();
            System.out.println(requestInfo);

            //响应
            StringBuilder responseContext = new StringBuilder();
            responseContext.append("<html><head><title>HTTP响应示例</title></head><body>Hello Tomcat!</body></html>");

            P223_Response rep = new P223_Response(client.getOutputStream());
            rep.println("<html><head><title>HTTP响应示例</title>");
            rep.println("</head><body>Hello Tomcat!</body></html>");
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
