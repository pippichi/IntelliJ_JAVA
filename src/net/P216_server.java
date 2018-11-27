package net;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

/**
 * 创建服务器
 * 写出数据:输出流
 * 读取数据:输入流
 * 群聊
 */
public class P216_server {

    private List<MyChannel> all = new ArrayList<>();

    /**
     *
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        new P216_server().start();
    }

    /**
     * 一个客户端 一条道路
     * 1、输入流
     * 2、输出流
     * 3、接收数据
     * 4、发送数据
     */

    public void start() throws IOException {
        ServerSocket server = new ServerSocket(9999);
        while(true) {
            Socket client = server.accept();
            //写出数据
            //输入流
            MyChannel channel = new MyChannel(client);
            all.add(channel); //统一管理
            new Thread(channel).start();//一条道路
        }

    }

    /**
     * 每个用户一条路
     */
    private class MyChannel implements Runnable{

        private DataInputStream dis;
        private DataOutputStream dos;
        private boolean isRunning = true;

        public MyChannel(Socket client){
            try {
                dis = new DataInputStream(client.getInputStream());
                dos = new DataOutputStream(client.getOutputStream());
            } catch (IOException e) {
//                e.printStackTrace();
                P216_closeUtil.closeAll(dis,dos);
                isRunning = false;
            }
        }

        /**
         * 读取数据
         * @return
         */
        private String receive(){
            String msg = "";
            try {
                msg = dis.readUTF();
            } catch (IOException e) {
//                e.printStackTrace();
                isRunning = false;
                P216_closeUtil.closeAll(dis);
                all.remove(this); //移除自身
            }
            return msg;
        }

        /**
         * 发送数据
         */
        private void send(String msg){
            if(msg==null||msg.equals(""))
                return;
            try {
                dos.writeUTF(msg);
                dos.flush();
            } catch (IOException e) {
//                e.printStackTrace();
                isRunning = false;
                P216_closeUtil.closeAll(dos);
                all.remove(this);//移除自身
            }
        }

        /**
         * 发送给其他客户端
         */
        private void sendOthers(){
            String msg = this.receive();
            //遍历容器
            for(MyChannel temp:all){
                if(temp==this)
                    continue;
                //发送给其他客户端
                temp.send(msg);
            }
        }

        @Override
        public void run() {
            while(isRunning){
                sendOthers();
            }
        }
    }

}
