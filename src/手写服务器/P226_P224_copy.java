package 手写服务器;

import java.io.IOException;
import java.net.ServerSocket;

/**
 * 创建服务器
 *
 * 1、请求
 * 2、响应
 */

public class P226_P224_copy {

    private ServerSocket server;
    public static final String CRLF = "\r\n";
    public static final String BLANK = " ";

    private boolean isShutDown = false;

    public static void main(String[] args) {
        P226_P224_copy server = new P226_P224_copy();
        server.start();
    }

    /**
     * 启动方法
     */
    public void start(int port){
        try {
            server = new ServerSocket(port);

            this.receive();
        } catch (IOException e) {
            e.printStackTrace();
            stop();
        }
    }
    public void start(){
        start(8888);
    }

    /**
     * 接收客户端
     */
    private void receive(){
        try {
            while (!isShutDown)
                new Thread(new P226_Dispatcher(server.accept())).start();
        } catch (IOException e) {
            e.printStackTrace();
            stop();
        }
    }

    /**
     * 停止服务器
     */
    public void stop(){
        isShutDown = true;
        FileUtil.closeAll(server);
    }
}
