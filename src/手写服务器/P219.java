package 手写服务器;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class P219 {

    private ServerSocket server;

    public static void main(String[] args) {
        P219 server = new P219();
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
            StringBuilder sb = new StringBuilder();
            //接收客户端的请求信息
            String msg;

            BufferedReader br = new BufferedReader(new InputStreamReader(client.getInputStream()));
            while((msg=br.readLine())!=null){
                sb.append(msg);
                sb.append("\r\n");
                if(msg==null)
                    break;
            }
            //接收客户端的请求信息
            String requestInfo = sb.toString().trim();
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
