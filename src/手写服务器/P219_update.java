package 手写服务器;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class P219_update {

    private ServerSocket server;

    public static void main(String[] args) {
        P219_update server = new P219_update();
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
